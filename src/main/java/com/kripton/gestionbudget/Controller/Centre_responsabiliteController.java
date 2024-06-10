package com.kripton.gestionbudget.Controller;
import java.security.Principal;
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
import com.kripton.gestionbudget.DTO.Centre_responsabiliteDto;
import com.kripton.gestionbudget.Interface.Centre_responsabiliteInterface;
import com.kripton.gestionbudget.entities.Centre_responsabilite;
@RestController
@RequestMapping("/centreResponsabilite")
public class Centre_responsabiliteController {

	@Autowired
	private Centre_responsabiliteInterface centre_responsabiliteInterface;
	
	@PostMapping
	public ResponseEntity<Centre_responsabiliteDto> AddCenterResponsability(@RequestBody Centre_responsabiliteDto c) {
		
		Centre_responsabiliteDto centreEntity =  centre_responsabiliteInterface.Add(c);
		
		return new ResponseEntity<Centre_responsabiliteDto>(centreEntity,HttpStatus.CREATED);
		
	}
	@GetMapping
	public List<Centre_responsabilite> getListCentre(Principal principal){
		
		return centre_responsabiliteInterface.getAll(principal.getName());
		
	}
	@DeleteMapping
	public ResponseEntity<Object> DeleteCentreResponsabilite(@RequestBody Centre_responsabiliteDto centre) {
		
		centre_responsabiliteInterface.Delete(centre);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	@PutMapping
	public ResponseEntity<Centre_responsabiliteDto> UpdateCentreResponsabilite(@RequestBody Centre_responsabiliteDto c) {
		Centre_responsabiliteDto centreEntity = centre_responsabiliteInterface.Update(c); 
		return new ResponseEntity<Centre_responsabiliteDto>(centreEntity,HttpStatus.ACCEPTED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Centre_responsabiliteDto> getOne(@PathVariable Integer id) {
		
		Centre_responsabiliteDto centreEntity =  centre_responsabiliteInterface.getById(id);
		return new ResponseEntity<Centre_responsabiliteDto>(centreEntity,HttpStatus.OK);

	}
	
}
