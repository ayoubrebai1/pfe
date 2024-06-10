package com.kripton.gestionbudget.DTO;


import java.util.List;
import com.kripton.gestionbudget.entities.Budget;
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id_detail_budget")

public class Detail_budgetDto {
	

	private Integer id_detail_budget;
	
	private float montant_detail_budget;
	private Budget budget;
	private Rubrique_budgetDto rubrique_budget ;
	private  String libelle;
	private  String status;
	private String argument;
	private List<MessageDto> messages;
	public List<MessageDto> getMessages() {
		return messages;
	}

	public void setMessages(List<MessageDto> messages) {
		this.messages = messages;
	}

	public String getArgument() {
		return argument;
	}

	public void setArgument(String argument) {
		this.argument = argument;
	}

	public Integer getId_detail_budget() {
		return id_detail_budget;
	}

	public void setId_detail_budget(Integer id_detail_budget) {
		this.id_detail_budget = id_detail_budget;
	}

	public float getMontant_detail_budget() {
		return montant_detail_budget;
	}

	public void setMontant_detail_budget(float montant_detail_budget) {
		this.montant_detail_budget = montant_detail_budget;
	}

	public Budget getBudget() {
		return budget;
	}

	public void setBudget(Budget budget) {
		this.budget = budget;
	}

	public Rubrique_budgetDto getRubrique_budget() {
		return rubrique_budget;
	}

	public void setRubrique_budget(Rubrique_budgetDto rubrique_budget) {
		this.rubrique_budget = rubrique_budget;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
