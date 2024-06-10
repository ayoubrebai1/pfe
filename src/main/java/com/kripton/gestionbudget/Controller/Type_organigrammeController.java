package com.kripton.gestionbudget.Controller;

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
import com.kripton.gestionbudget.DTO.Type_organigrammeDto;
import com.kripton.gestionbudget.Interface.Type_organigrammeInterface;
@RestController
@RequestMapping("/typeOrganigramme")
public class Type_organigrammeController {

	@Autowired
	private Type_organigrammeInterface type_organigrammeInterface;

	@GetMapping
	public ResponseEntity<List<Type_organigrammeDto>> getAllTypeOrganigrammes() {
		List<Type_organigrammeDto> listTypeOrganigramme = type_organigrammeInterface.getAll();
		return new ResponseEntity<List<Type_organigrammeDto>>(listTypeOrganigramme, HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<Object> DeleteTypeOrganigramme(@RequestBody Type_organigrammeDto typeOrganigramme) {
		type_organigrammeInterface.Delete(typeOrganigramme);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

	@PostMapping
	public ResponseEntity<Type_organigrammeDto> AddTypeOrganigramme(
			@RequestBody Type_organigrammeDto typeOrganigramme) {
		Type_organigrammeDto typeDto = type_organigrammeInterface.Add(typeOrganigramme);
		return new ResponseEntity<Type_organigrammeDto>(typeDto, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Type_organigrammeDto> UpdateTypeorganigramme(
			@RequestBody Type_organigrammeDto typeOrganigramme) {
		Type_organigrammeDto typeDto = type_organigrammeInterface.Update(typeOrganigramme);
		return new ResponseEntity<Type_organigrammeDto>(typeDto, HttpStatus.ACCEPTED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Type_organigrammeDto> getTypeOrganigramme(@PathVariable Integer id) {
		Type_organigrammeDto typeDto = type_organigrammeInterface.getById(id);
		return new ResponseEntity<Type_organigrammeDto>(typeDto, HttpStatus.OK);

	}
}
