package com.kripton.gestionbudget.Interface;


import java.util.List;
import com.kripton.gestionbudget.DTO.Rubrique_budgetDto;

public interface Rubrique_budgerInterface {
	public List<Rubrique_budgetDto> getAll();
	public void Delete(Rubrique_budgetDto rubriqueBudget);
	public Rubrique_budgetDto Add(Rubrique_budgetDto rubriqueBudget);
	public Rubrique_budgetDto Update(Rubrique_budgetDto rubriqueBudget);
	public Rubrique_budgetDto getById(Integer id);
	public Rubrique_budgetDto getTypeByLibelle(String libelle);

}
