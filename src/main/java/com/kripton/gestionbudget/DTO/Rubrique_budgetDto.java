package com.kripton.gestionbudget.DTO;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id_rubrique")

public class Rubrique_budgetDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id_rubrique;
	@NotBlank
	private String libelle;
	private String sens ;
	private List<Detail_budgetDto> details_budget;
	public Integer getId_rubrique() {
		return id_rubrique;
	}
	public void setId_rubrique(Integer id_rubrique) {
		this.id_rubrique = id_rubrique;
	}
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getSens() {
		return sens;
	}
	public void setSens(String sens) {
		this.sens = sens;
	}
	public List<Detail_budgetDto> getDetails_budget() {
		return details_budget;
	}
	public void setDetails_budget(List<Detail_budgetDto> details_budget) {
		this.details_budget = details_budget;
	}
}
