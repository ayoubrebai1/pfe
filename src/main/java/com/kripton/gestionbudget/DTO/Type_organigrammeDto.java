package com.kripton.gestionbudget.DTO;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id_type_organigramme")

public class Type_organigrammeDto implements Serializable{
	
	private static final long serialVersionUID = -8286257874565468342L;
	
	
	private Integer id_type_organigramme;
	@NotBlank
	private String libelle_type_organigramme;
	private List<OrganigrammeDto> organigrammes;
	public List<OrganigrammeDto> getOrganigrammes() {
		return organigrammes;
	}
	public void setOrganigrammes(List<OrganigrammeDto> organigrammes) {
		this.organigrammes = organigrammes;
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
