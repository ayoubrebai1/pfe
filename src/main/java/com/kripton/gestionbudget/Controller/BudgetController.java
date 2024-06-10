package com.kripton.gestionbudget.Controller;
import java.util.List;

import javax.validation.Valid;

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
import com.kripton.gestionbudget.DTO.BudgetDto;
import com.kripton.gestionbudget.Interface.BudgetInterface;

@RestController
@RequestMapping("/budget")
public class BudgetController {
	@Autowired
	private BudgetInterface budgetinterface;

	
	@GetMapping
	ResponseEntity<List<BudgetDto>> getListBudget() {
		
		List<BudgetDto> listBudget = budgetinterface.getAll();
		return new ResponseEntity<List<BudgetDto>>(listBudget, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<BudgetDto> AddBudget(@RequestBody @Valid BudgetDto budget) {

		
		BudgetDto createBudget =  budgetinterface.Add(budget);
		
		
		return new ResponseEntity<BudgetDto>(createBudget, HttpStatus.CREATED);

	}

	@DeleteMapping
	public ResponseEntity<Object> DeleteBudget(@RequestBody BudgetDto budget) {
		
		budgetinterface.Delete(budget);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	} 

	@PutMapping
	public ResponseEntity<BudgetDto> UpdateBudget(@RequestBody BudgetDto budget) {
		
		BudgetDto updatebudget = budgetinterface.Update( budget);
		
		
		return new ResponseEntity<BudgetDto>(updatebudget, HttpStatus.ACCEPTED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<BudgetDto> getByOne(@PathVariable Integer id) {
		BudgetDto budgetEntity = budgetinterface.getById(id);
		return new ResponseEntity<BudgetDto>(budgetEntity, HttpStatus.OK);
	}
     @GetMapping("/updateMontant/{id}/{montant}")
     public float UpdateMontatant_total (@PathVariable float montant,@PathVariable Integer id ) {
    	float montant_total= budgetinterface.UpdateMontant(montant, id);
    	return montant_total;
     }
}
