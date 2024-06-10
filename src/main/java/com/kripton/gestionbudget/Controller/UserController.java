package com.kripton.gestionbudget.Controller;

import java.util.List;

import javax.validation.Valid;

import com.kripton.gestionbudget.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kripton.gestionbudget.DTO.UserDto;
import com.kripton.gestionbudget.Interface.UserInterface;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserInterface userInterface;

    @GetMapping
	ResponseEntity<List<UserDto>> getListBudget() {
		
		List<UserDto> users = userInterface.getAll();
		return new ResponseEntity<List<UserDto>>(users, HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<String> addUser(@RequestBody @Valid UserDto user) {
		userInterface.Add(user);
		return new ResponseEntity<String>("user ajouter avec succces ",HttpStatus.CREATED);
	}
	@GetMapping("/{email}")
	public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email){
		UserDto userDto = userInterface.getUser(email);
		return new ResponseEntity<UserDto>(userDto,HttpStatus.OK);
	}
	@DeleteMapping
     public ResponseEntity<Object> DeleteBudget(@RequestBody UserDto user) {
		
		userInterface.Delete(user);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	} 
	@PutMapping
	public ResponseEntity<UserDto> UpdateBudget(@RequestBody UserDto user) {
		
		UserDto updateUser = userInterface.Update( user);
		
		
		return new ResponseEntity<UserDto>(updateUser, HttpStatus.ACCEPTED);
	}
	@PutMapping("/changeStatus")
	public ResponseEntity<UserDto> ChangeStatus(@RequestBody UserDto user) {
		
		UserDto updateUser = userInterface.changeStatus( user);
		
		
		return new ResponseEntity<UserDto>(updateUser, HttpStatus.ACCEPTED);
	}
	@PutMapping("/resetPassword")
	public ResponseEntity<UserDto> ResetPassword(@RequestBody UserDto user) {
		
		UserDto updateUser = userInterface.resetPassword( user);
		
		
		return new ResponseEntity<UserDto>(updateUser, HttpStatus.ACCEPTED);
	}
	
	

}
