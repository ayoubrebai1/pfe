package com.kripton.gestionbudget.Controller;


import java.util.ArrayList;
import java.util.List;

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
import com.kripton.gestionbudget.DTO.OrganigrammeDto;
import com.kripton.gestionbudget.Interface.OrganigrammeInterface;

@RestController
@RequestMapping("/organigramme")
public class OrganigrammeController {
	@Autowired
	private OrganigrammeInterface organigrammeInterface ;
	@GetMapping
	public ResponseEntity<List<OrganigrammeDto>> getAllOrganigrammes(){
		List<OrganigrammeDto> listDto = organigrammeInterface.getAll();
		return new ResponseEntity<List<OrganigrammeDto>>(listDto,HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Object> Addorganigramme(@RequestBody ArrayList<OrganigrammeDto> organigrammeDto ){
		String msg =  organigrammeInterface.Add(organigrammeDto);
		return new ResponseEntity<Object>(msg,HttpStatus.CREATED);
		
	}
	@DeleteMapping
	public ResponseEntity<Object> DeleteOrganigramme(@RequestBody OrganigrammeDto organigrammeDto ){
		organigrammeInterface.Delete(organigrammeDto);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	@PutMapping
	public ResponseEntity<OrganigrammeDto> UpdateOrganigramme(@RequestBody OrganigrammeDto organigrammeDto){
		OrganigrammeDto newOrganigramme = organigrammeInterface.Update(organigrammeDto);
		return new ResponseEntity<OrganigrammeDto>(newOrganigramme,HttpStatus.ACCEPTED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<OrganigrammeDto> getOrganigramme(@PathVariable String id){
		OrganigrammeDto newOrganigramme = organigrammeInterface.getById(id);
		return new ResponseEntity<OrganigrammeDto>(newOrganigramme,HttpStatus.OK);
	}

}
