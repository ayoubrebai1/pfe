package com.kripton.gestionbudget.security;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kripton.gestionbudget.SpringApplicationContext;
import com.kripton.gestionbudget.DTO.UserDto;
import com.kripton.gestionbudget.DTO.UserLoginRequest;
import com.kripton.gestionbudget.Interface.UserInterface;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	private final AuthenticationManager authenticationManager;

	public AuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	
	// cette methode est déclecher si l'utilisateur envoie une requete avec /login avec methode post
	 
	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException {
		try {

			UserLoginRequest creds = new ObjectMapper().readValue(req.getInputStream(), UserLoginRequest.class);
    // vérifier si l'utilisateur existe
			return authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(creds.getEmail(), creds.getPassword(), new ArrayList<>()));

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	// déclencher si l'utilisateur existe déja
	  @Override
	    protected void successfulAuthentication(HttpServletRequest req,
	                                            HttpServletResponse res,
	                                            FilterChain chain,
	                                            Authentication auth) throws IOException, ServletException {
	        
	        String email = ((User) auth.getPrincipal()).getUsername(); 
	        
	        UserInterface userInterface = (UserInterface)SpringApplicationContext.getBean("userService");
	        UserDto userDto = userInterface.getUser(email);
	        String token = Jwts.builder()
	                .setSubject(email)
	                .claim("id", userDto.getId_user())
	                .claim("Role", userDto.getRole())
	                //.claim("id_centre_responsabilité", userDto.getCentre().getId_centre_responsabilite())
	                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
	                .signWith(SignatureAlgorithm.HS512, SecurityConstants.TOKEN_SECRET )
	                .compact();
	        
	       
	        
	        //res.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);
	        
	       // res.addIntHeader("user_id", userDto.getId_user());
	       
	        if(userDto.getCentre()!= null) {
	        	 res.getWriter().write("{\"token\": \"" + token + "\", \"role\": \""+ userDto.getRole() + "\",\"id_centre\":\""+userDto.getCentre().getId_centre_responsabilite()+ "\",\"id\":\""+userDto.getId_user()+"\"}");
	        }
	        else {
	        	res.getWriter().write("{\"token\": \"" + token + "\", \"role\": \""+ userDto.getRole() + "\",\"id\":\""+userDto.getId_user()+"\"}");
	        }

	    }  
}


