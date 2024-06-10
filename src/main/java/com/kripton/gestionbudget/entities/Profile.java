package com.kripton.gestionbudget.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Profile implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2416055430943334690L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_profile;
	
	private String libelle;

	public Profile(Integer id_profile, String libelle) {
		super();
		this.id_profile = id_profile;
		this.libelle = libelle;
	}

	public Integer getId_profile() {
		return id_profile;
	}

	public void setId_profile(Integer id_profile) {
		this.id_profile = id_profile;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
