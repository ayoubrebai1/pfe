package com.kripton.gestionbudget.services;


import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kripton.gestionbudget.DTO.Rubrique_budgetDto;
import com.kripton.gestionbudget.Interface.Rubrique_budgerInterface;
import com.kripton.gestionbudget.Repository.Rubrique_budgetRepository;
import com.kripton.gestionbudget.entities.Rubrique_budget;
@Service
public class Rubrique_budgetService implements Rubrique_budgerInterface{

	@Autowired
	private Rubrique_budgetRepository rubrique_budgetRepository;
	ModelMapper modelMapper = new ModelMapper();
	@Override
	public List<Rubrique_budgetDto> getAll() {
		
		List<Rubrique_budget> listRubrique = rubrique_budgetRepository.findAll();
		List<Rubrique_budgetDto> listDto = new ArrayList<Rubrique_budgetDto>();
		for(Rubrique_budget organigramme: listRubrique) {
			Rubrique_budgetDto NDto = modelMapper.map(organigramme,Rubrique_budgetDto.class);
			listDto.add(NDto);
		}
	
		return listDto;
		
	}
	@Override
	public void Delete(Rubrique_budgetDto rubriqueBudget) {
		//Rubrique_budget rubrique = modelMapper.map(rubriqueBudget, Rubrique_budget.class);
		rubrique_budgetRepository.deleteById(rubriqueBudget.getId_rubrique());
	}
	@Override
	public Rubrique_budgetDto Add(Rubrique_budgetDto rubriqueBudget) {
		Rubrique_budget rubrique = modelMapper.map(rubriqueBudget, Rubrique_budget.class);
		Rubrique_budget rubriqueEntity = rubrique_budgetRepository.save(rubrique);
		Rubrique_budgetDto rebriqueDto = modelMapper.map(rubriqueEntity, Rubrique_budgetDto.class);
		return rebriqueDto;
	}
	@Override
	public Rubrique_budgetDto Update(Rubrique_budgetDto rubriqueBudget) {
		Rubrique_budget rubrique = modelMapper.map(rubriqueBudget, Rubrique_budget.class);
		Rubrique_budget rubriqueEntity = rubrique_budgetRepository.save(rubrique);
		Rubrique_budgetDto rebriqueDto = modelMapper.map(rubriqueEntity, Rubrique_budgetDto.class);
		return rebriqueDto;
	}
	@Override
	public Rubrique_budgetDto getById(Integer id) {
		Rubrique_budget rubriqueEntity = rubrique_budgetRepository.findById(id).get();
		Rubrique_budgetDto rebriqueDto = modelMapper.map(rubriqueEntity, Rubrique_budgetDto.class);
		return rebriqueDto;
	}
	@Override
	public Rubrique_budgetDto getTypeByLibelle(String libelle) {
		Rubrique_budget rubriqueEntity = rubrique_budgetRepository.findByLibelle(libelle);
		Rubrique_budgetDto rebriqueDto = modelMapper.map(rubriqueEntity, Rubrique_budgetDto.class);
		return rebriqueDto;
		
	}


}
