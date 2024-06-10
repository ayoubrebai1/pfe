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

import com.kripton.gestionbudget.DTO.Rubrique_budgetDto;
import com.kripton.gestionbudget.Interface.Rubrique_budgerInterface;


@RestController
@RequestMapping("/rubriqueBudget")
public class Rubrique_budgetController {
	@Autowired
	private Rubrique_budgerInterface rubrique_budgerInterface;
	
	@GetMapping
	public ResponseEntity<List<Rubrique_budgetDto>> getListRubriqueBudget(){
		List<Rubrique_budgetDto> listRubriqueDto = rubrique_budgerInterface.getAll();
		return new ResponseEntity<List<Rubrique_budgetDto>>(listRubriqueDto,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Rubrique_budgetDto> getByOne(@PathVariable Integer id) {
		Rubrique_budgetDto rubriqueEntity =  rubrique_budgerInterface.getById(id);
		return new ResponseEntity<Rubrique_budgetDto>(rubriqueEntity,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Rubrique_budgetDto> ajouterRubriqueBudget(@RequestBody Rubrique_budgetDto rubriqueBudget) {
		
		Rubrique_budgetDto rubriqueEntity = rubrique_budgerInterface.Add(rubriqueBudget);
		return new ResponseEntity<Rubrique_budgetDto>(rubriqueEntity,HttpStatus.CREATED);
	}
	@DeleteMapping
	public ResponseEntity<Object> supprimerRubriqueBudget(@RequestBody Rubrique_budgetDto rubriqueBudget) {
		rubrique_budgerInterface.Delete(rubriqueBudget);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	@PutMapping
	public ResponseEntity<Rubrique_budgetDto> modifierRubriqueBudget(@RequestBody Rubrique_budgetDto rubriqueBudget) {
		
		Rubrique_budgetDto rubriqueEntity = rubrique_budgerInterface.Update( rubriqueBudget);
		return new ResponseEntity<Rubrique_budgetDto>(rubriqueEntity,HttpStatus.ACCEPTED);
		
	}
	@GetMapping("/get/{libelle}")
	public ResponseEntity<Rubrique_budgetDto> GetByType(@PathVariable String libelle){
		Rubrique_budgetDto rubriqueEntity = rubrique_budgerInterface.getTypeByLibelle(libelle);
		return new ResponseEntity<Rubrique_budgetDto>(rubriqueEntity,HttpStatus.OK);
	}
	

}
