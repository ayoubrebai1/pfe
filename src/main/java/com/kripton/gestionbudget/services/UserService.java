package com.kripton.gestionbudget.services;


import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.kripton.gestionbudget.DTO.UserDto;
import com.kripton.gestionbudget.Interface.UserInterface;
import com.kripton.gestionbudget.Repository.UserRepository;
import com.kripton.gestionbudget.entities.User;
@Service
public class UserService implements UserInterface {

	ModelMapper modelMapper = new ModelMapper();
	@Autowired
	private UserRepository userRepository; 
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public List<UserDto> getAll() {
		
		List<User> users = userRepository.findAll();
		List<UserDto> listDto = new ArrayList<UserDto>();
		for(User user: users) {
			UserDto NDto = modelMapper.map(user,UserDto.class);
			listDto.add(NDto);
		}
	
		return listDto;
	}

	@Override
	public UserDto Add(UserDto user) {
		User verifieUser = userRepository.findByEmail(user.getEmail());
		if(verifieUser != null) throw new RuntimeException("user existe");
		User newUser = modelMapper.map(user, User.class);
		newUser.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		User userEntity = userRepository.save(newUser);
		UserDto userDto = modelMapper.map(userEntity, UserDto.class);
		return userDto;
	}

	@Override
	public void Delete(UserDto user) {
		//int x = user.getId_user();
		//User newUser = modelMapper.map(user, User.class);
		userRepository.deleteById(user.getId_user());
		
	}

	@Override
	public UserDto Update(UserDto user) {		
		User newUser = modelMapper.map(user, User.class);
		newUser.setEncryptedPassword(user.getPassword());
		User userEntity = userRepository.save(newUser);
		UserDto userDto = modelMapper.map(userEntity, UserDto.class);
		return userDto;
	}

	

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
		if(user == null ) throw new UsernameNotFoundException(email); 
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getEncryptedPassword(), new ArrayList<>());
	}

	@Override
	public UserDto getUser(String email) {
		User user = userRepository.findByEmail(email);
		if(user == null || !user.getStatus() ) throw new UsernameNotFoundException(email); 
		UserDto userDto =modelMapper.map(user, UserDto.class);
		return userDto;
	}

	@Override
	public UserDto changeStatus(UserDto user) {

		User newUser = userRepository.findById(user.getId_user()).get();
		newUser.setEncryptedPassword(user.getPassword());
		newUser.setStatus(!newUser.getStatus());
		User userEntity = userRepository.save(newUser);
		UserDto userDto = modelMapper.map(userEntity, UserDto.class);
		return userDto;
		
	}

	@Override
	public UserDto resetPassword(UserDto user) {
		User newUser = userRepository.findById(user.getId_user()).get();
		newUser.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		User userEntity = userRepository.save(newUser);
		UserDto userDto = modelMapper.map(userEntity, UserDto.class);
		return userDto;
	}

	

}
