package com.kripton.gestionbudget.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id_type_organigramme")

public class Type_organigramme implements Serializable {


	private static final long serialVersionUID = 1989174658540785108L;
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_type_organigramme;
	private String libelle_type_organigramme;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "type_organigramme")
	private List<Organigramme> organigrammes;
	public List<Organigramme> getOrganigrammes() {
		return organigrammes;
	}

	public void setOrganigrammes(List<Organigramme> organigrammes) {
		this.organigrammes = organigrammes;
	}

	public Type_organigramme(Integer id_type_organigramme, String libelle_type_organigramme) {
		super();
		this.id_type_organigramme = id_type_organigramme;
		this.libelle_type_organigramme = libelle_type_organigramme;
	}

	public Type_organigramme() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId_type_organigramme() {
		return id_type_organigramme;
	}

	public void setId_type_organigramme(Integer id_type_organigramme) {
		this.id_type_organigramme = id_type_organigramme;
	}

	public String getLibelle_type_organigramme() {
		return libelle_type_organigramme;
	}

	public void setLibelle_type_organigramme(String libelle_type_organigramme) {
		this.libelle_type_organigramme = libelle_type_organigramme;
	}

	

}
