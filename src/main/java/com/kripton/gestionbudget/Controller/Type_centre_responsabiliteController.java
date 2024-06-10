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

import com.kripton.gestionbudget.DTO.Type_centre_responsabiliteDto;
import com.kripton.gestionbudget.Interface.Type_centre_responsabiliteInterface;


@RestController
@RequestMapping("/TypeCentreResponsabilite")

public class Type_centre_responsabiliteController {
	@Autowired
	private Type_centre_responsabiliteInterface type_centre_responsabiliteInterface;
	
	@GetMapping
	
	public ResponseEntity<List<Type_centre_responsabiliteDto>> getTypeCentreResponsabilite()
	{
		List<Type_centre_responsabiliteDto>  listTypeCentre = type_centre_responsabiliteInterface.getAll();
		return new ResponseEntity<List<Type_centre_responsabiliteDto>>(listTypeCentre,HttpStatus.ACCEPTED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Type_centre_responsabiliteDto> getByOne(@PathVariable Integer id) {
		Type_centre_responsabiliteDto typeCentre =  type_centre_responsabiliteInterface.getById(id);
		return new ResponseEntity<Type_centre_responsabiliteDto>(typeCentre,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Type_centre_responsabiliteDto> ajouterTypeResponsabilite(@RequestBody Type_centre_responsabiliteDto t)
	{
		Type_centre_responsabiliteDto typeCentre = type_centre_responsabiliteInterface.Add(t);
		return new ResponseEntity<Type_centre_responsabiliteDto>(typeCentre,HttpStatus.CREATED);
	}
	@DeleteMapping
	public ResponseEntity<Object> supprimerTypeResponsabilite(@RequestBody Type_centre_responsabiliteDto t) {
		type_centre_responsabiliteInterface.Delete(t);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	@PutMapping
	public ResponseEntity<Type_centre_responsabiliteDto> modifierTypeCentreResponsabilite(@RequestBody Type_centre_responsabiliteDto t) {
	
		Type_centre_responsabiliteDto typeCentre = type_centre_responsabiliteInterface.Update( t);
		return new ResponseEntity<Type_centre_responsabiliteDto>(typeCentre,HttpStatus.ACCEPTED);
	}

}
