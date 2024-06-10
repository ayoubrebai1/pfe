package com.kripton.gestionbudget.services;


import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kripton.gestionbudget.DTO.BudgetDto;
import com.kripton.gestionbudget.Interface.BudgetInterface;

import com.kripton.gestionbudget.Repository.BudgetRepository;
import com.kripton.gestionbudget.entities.Budget;
@Service
public class BudgetService implements BudgetInterface {

	@Autowired
	BudgetRepository budgetrepository;
	ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public List<BudgetDto> getAll() {
		
		List<Budget> budgets =  budgetrepository.findAll();
		
		//Type listType = new TypeToken<List<BudgetDto>>() {}.getType();
		List<BudgetDto> ListbudgetsDto = new ArrayList<BudgetDto>();
		for(Budget budget: budgets) {
			BudgetDto BDto = modelMapper.map(budget,BudgetDto.class);
			ListbudgetsDto.add(BDto);
		}
		//List<BudgetDto> ListbudgetsDto = modelMapper.map(budgets,listType);
		
		return ListbudgetsDto;
	}

	@Override
	public void Delete(BudgetDto budget) {
		//Budget newBudget = modelMapper.map(budget, Budget.class);
		budgetrepository.deleteById(budget.getId_budget());
	}

	@Override
	public BudgetDto Add(BudgetDto budget)  {
        
        
        Budget newBudget = modelMapper.map(budget, Budget.class);
		Budget budgetEntity = budgetrepository.save(newBudget);
		BudgetDto budgetDto = modelMapper.map(budgetEntity, BudgetDto.class);
	
		return budgetDto;
	}

	@Override
	public BudgetDto Update(BudgetDto budget) {

		Budget newBudget = modelMapper.map(budget, Budget.class);
		
		Budget budgetEntity = budgetrepository.save(newBudget);
		BudgetDto budgetDto = modelMapper.map(budgetEntity, BudgetDto.class);
		
		return budgetDto;
	}

	@Override
	public BudgetDto getById(Integer id) {
		Budget budget = budgetrepository.findById(id).get();
		BudgetDto budgetDto = modelMapper.map(budget, BudgetDto.class);
		return budgetDto;
	}

	@Override
	public float UpdateMontant(float montant,Integer id_budget) {
		Budget budget = budgetrepository.findById(id_budget).get();
		
		budget.setMontant_total(budget.getMontant_total()+ montant);
		float montant_total = budget.getMontant_total();
		budgetrepository.save(budget);
		return montant_total;
	}

}
