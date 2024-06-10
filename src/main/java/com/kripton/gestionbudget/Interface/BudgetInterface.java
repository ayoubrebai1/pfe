package com.kripton.gestionbudget.Interface;


import java.util.List;

import com.kripton.gestionbudget.DTO.BudgetDto;



public interface BudgetInterface {
	public List<BudgetDto> getAll();
	public void Delete (BudgetDto budget);
	public BudgetDto Add(BudgetDto budget);
	public BudgetDto Update(BudgetDto budget);
	public BudgetDto getById(Integer id);
	public float UpdateMontant(float montant,Integer id_budget);

}
