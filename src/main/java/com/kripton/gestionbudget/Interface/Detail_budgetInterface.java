package com.kripton.gestionbudget.Interface;


import java.util.List;


import com.kripton.gestionbudget.DTO.Detail_budgetDto;


public interface Detail_budgetInterface {
	
	public List<Detail_budgetDto> getAll();
	public void Delete(Detail_budgetDto detailBudget);
	public Detail_budgetDto Add(Detail_budgetDto detailBudget);
	public Detail_budgetDto Update( Detail_budgetDto detailBudget);
	public Detail_budgetDto getById(Integer id);
	public Detail_budgetDto changeStatus(Detail_budgetDto status);
	public Detail_budgetDto sendMessage(Detail_budgetDto detailBudget);
}
