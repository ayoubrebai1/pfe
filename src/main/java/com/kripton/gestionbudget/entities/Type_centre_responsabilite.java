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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id_type_centre_responsabilite")

public class Type_centre_responsabilite implements Serializable {

	
	private static final long serialVersionUID = 4557084759526267602L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_type_centre_responsabilite;
	@Column(unique = true)
	private String libelle_type_centre_responsabilite;
	@OneToMany(mappedBy="type_centre_responsabilite", cascade=CascadeType.ALL)
	private List<Centre_responsabilite> centres_responsabilite;
    
	public Type_centre_responsabilite(Integer id_type_centre_responsabilite,
			String libelle_type_centre_responsabilite) {
		super();
		this.id_type_centre_responsabilite = id_type_centre_responsabilite;
		this.libelle_type_centre_responsabilite = libelle_type_centre_responsabilite;
	}
    
	public Type_centre_responsabilite() {
		super();
		
	}

	public Integer getId_type_centre_responsabilite() {
		return id_type_centre_responsabilite;
	}

	public void setId_type_centre_responsabilite(Integer id_type_centre_responsabilite) {
		this.id_type_centre_responsabilite = id_type_centre_responsabilite;
	}

	public String getLibelle_type_centre_responsabilite() {
		return libelle_type_centre_responsabilite;
	}

	public void setLibelle_type_centre_responsabilite(String libelle_type_centre_responsabilite) {
		this.libelle_type_centre_responsabilite = libelle_type_centre_responsabilite;
	}
}
