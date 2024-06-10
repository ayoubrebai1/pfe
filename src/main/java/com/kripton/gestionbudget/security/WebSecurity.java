package com.kripton.gestionbudget.security;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.kripton.gestionbudget.services.UserService;


@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{

	  private final UserService userDetailsService;
	  private final BCryptPasswordEncoder bCryptPasswordEncoder;
	  
	  public WebSecurity(UserService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
	        this.userDetailsService = userDetailsService;
	        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	    }
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		http
		    .cors().and() //activation du cors 
		    .csrf().disable() //desactivation du csrf
			.authorizeRequests() //Autoriser les requêtes du client
			.antMatchers(SecurityConstants.SIGN_UP_URL,"/chat","/user","/swagger-ui.html")
			// Autoriser la requete  /user avec la methode post
			.permitAll()
			
			.anyRequest().authenticated() // tous les autres requetes il faut que user soit authentifier
			.and().addFilter(new AuthenticationFilter(authenticationManager())) // créer le token 
			.addFilter(new AuthorizationFilter(authenticationManager())) //verifier la validité de token
			.sessionManagement()
		    .sessionCreationPolicy(SessionCreationPolicy.STATELESS); // changer la mode statfull car on a communiquer avec angular
			
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}
}
