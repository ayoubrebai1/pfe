package com.kripton.gestionbudget.DTO;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id_budget")
public class BudgetDto implements Serializable{

	private static final long serialVersionUID = 447640628281479550L;
	private Integer id_budget;
	@NotBlank(message = "libelle budget doit étre non null")
	private String libelle_budget;
	//@Positive(message = "montant budget doit ètre positif")
	private float montant_total;
	private Date date_budget;
	private List<Detail_budgetDto> details_budget;
	private Centre_responsabiliteDto centre_responsabilite;
	public Integer getId_budget() {
		return id_budget;
	}
	public void setId_budget(Integer id_budget) {
		this.id_budget = id_budget;
	}
	public String getLibelle_budget() {
		return libelle_budget;
	}
	public void setLibelle_budget(String libelle_budget) {
		this.libelle_budget = libelle_budget;
	}
	public float getMontant_total() {
		return montant_total;
	}
	public void setMontant_total(float montant_total) {
		this.montant_total = montant_total;
	}
	public Date getDate_budget() {
		return date_budget;
	}
	public void setDate_budget(Date date_budget) {
		this.date_budget = date_budget;
	}
	public Centre_responsabiliteDto getCentre_responsabilite() {
		return centre_responsabilite;
	}
	public void setCentre_responsabilite(Centre_responsabiliteDto centre_responsabilite) {
		this.centre_responsabilite = centre_responsabilite;
	}
	public List<Detail_budgetDto> getDetails_budget() {
		return details_budget;
	}
	public void setDetails_budget(List<Detail_budgetDto> details_budget) {
		this.details_budget = details_budget;
	}
}