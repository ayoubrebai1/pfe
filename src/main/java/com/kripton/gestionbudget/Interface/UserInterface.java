package com.kripton.gestionbudget.Interface;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.kripton.gestionbudget.DTO.UserDto;

public interface UserInterface extends UserDetailsService{
	List<UserDto> getAll();
	UserDto Add(UserDto user) ;
	void Delete(UserDto user);
	UserDto Update(UserDto user);
	UserDto getUser(String  email);
	UserDto changeStatus(UserDto user);
	UserDto resetPassword(UserDto user);
	

}
