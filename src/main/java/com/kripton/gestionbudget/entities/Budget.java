package com.kripton.gestionbudget.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id_budget")
public class Budget implements Serializable {

	
	private static final long serialVersionUID = -4715073480176826326L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_budget;
	
	@OneToMany(mappedBy="budget", cascade=CascadeType.ALL,orphanRemoval=true)
	
	private List<Detail_budget> details_budget;
	
	public Budget(Integer id_budget, String libelle_budget, long montant_total, Date date_budget) {
		super();
		this.id_budget = id_budget;
		this.libelle_budget = libelle_budget;
		this.montant_total = montant_total;
		this.date_budget = date_budget;
	}
	public Budget() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String libelle_budget;
	private float montant_total;
	private Date date_budget;
	
	@ManyToOne
	@JoinColumn(name="id_centre_responsabilite")
	private Centre_responsabilite centre_responsabilite ;
	public Integer getId_budget() {
		return id_budget;
	}
	public List<Detail_budget> getDetails_budget() {
		return details_budget;
	}
	public void setDetails_budget(List<Detail_budget> details_budget) {
		this.details_budget = details_budget;
	}
	public Centre_responsabilite getCentre_responsabilite() {
		return centre_responsabilite;
	}
	//@JsonSetter
	public void setCentre_responsabilite(Centre_responsabilite centre_responsabilite) {
		this.centre_responsabilite = centre_responsabilite;
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
}
