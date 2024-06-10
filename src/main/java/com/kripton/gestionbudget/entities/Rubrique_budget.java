package com.kripton.gestionbudget.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id_rubrique")

public class Rubrique_budget implements Serializable {

	
	private static final long serialVersionUID = 8565695200265952763L;
	
	public Rubrique_budget(Integer id_rubrique, String libelle_rubrique, String sens) {
		super();
		this.id_rubrique = id_rubrique;
		this.libelle = libelle_rubrique;
		this.sens = sens;
	}

	public Rubrique_budget() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_rubrique;
	
	public List<Detail_budget> getDetails_budget() {
		return details_budget;
	}

	public void setDetails_budget(List<Detail_budget> details_budget) {
		this.details_budget = details_budget;
	}
	@Column( unique = true)
	private String libelle;
	
	private String sens;
	//@JsonManagedReference
	@OneToMany(mappedBy="rubrique_budget",cascade = CascadeType.REMOVE)	
	private List<Detail_budget> details_budget;
	

}
