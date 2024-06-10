package com.kripton.gestionbudget.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kripton.gestionbudget.DTO.ProfileDto;
import com.kripton.gestionbudget.Interface.ProfileInterface;

@RestController
@RequestMapping("/profile")
public class ProfileController {
	
	@Autowired
	private ProfileInterface profileInterface ;
	
	@GetMapping
	ResponseEntity<List<ProfileDto>> getListProfile(){
		List<ProfileDto> listProfile = profileInterface.getAll();
		return new ResponseEntity<List<ProfileDto>>(listProfile,HttpStatus.OK);
	}
	
	@PostMapping
	ResponseEntity<ProfileDto> AddProfile(@RequestBody ProfileDto profile){
		
		ProfileDto newProfile = profileInterface.Add(profile);
		return new ResponseEntity<ProfileDto>(newProfile,HttpStatus.CREATED);
	}
	@DeleteMapping
	public ResponseEntity<Object> DeleteProfil(@RequestBody ProfileDto profil) {
		
		profileInterface.Delete(profil);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	} 

}
