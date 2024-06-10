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
import com.kripton.gestionbudget.DTO.Detail_budgetDto;
import com.kripton.gestionbudget.Interface.Detail_budgetInterface;
@RestController
@RequestMapping("/detailBudget")
public class Detail_budgetController {
	
	@Autowired
	private Detail_budgetInterface detailBudgetinterface;
	@GetMapping
	public ResponseEntity<List<Detail_budgetDto>> getListDetailBudget(){
		List<Detail_budgetDto> listDetailBudget = detailBudgetinterface.getAll();
		return new ResponseEntity<List<Detail_budgetDto>>(listDetailBudget,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Detail_budgetDto> getByOne(@PathVariable Integer id) {
		Detail_budgetDto detailBudget =  detailBudgetinterface.getById(id);
		return new ResponseEntity<Detail_budgetDto>(detailBudget,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Detail_budgetDto> ajouterDetailBudget(@RequestBody Detail_budgetDto detailBudget) {
		Detail_budgetDto detailBudgetEntity = detailBudgetinterface.Add(detailBudget);
		return new ResponseEntity<Detail_budgetDto>(detailBudgetEntity,HttpStatus.CREATED);
	}
	@DeleteMapping
	public ResponseEntity<Object> supprimerDetailBudget(@RequestBody Detail_budgetDto detailBudget) {
		detailBudgetinterface.Delete(detailBudget);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	@PutMapping
	public ResponseEntity<Detail_budgetDto> modifierDetailBudget(@RequestBody Detail_budgetDto detailBudget)
	{
		Detail_budgetDto detailBudgetEntity = detailBudgetinterface.Update( detailBudget);
		return new ResponseEntity<Detail_budgetDto>(detailBudgetEntity,HttpStatus.ACCEPTED);
	}
	@PutMapping("/changeStatus")
	public Detail_budgetDto ChangeStatus(@RequestBody Detail_budgetDto status) {
		Detail_budgetDto detailBudget = detailBudgetinterface.changeStatus(status);
		return detailBudget;
	}
	@PutMapping("/sendMessage")
	public Detail_budgetDto SendMessage(@RequestBody Detail_budgetDto status) {
		Detail_budgetDto detailBudget = detailBudgetinterface.sendMessage(status);
		return detailBudget;
	}
}
