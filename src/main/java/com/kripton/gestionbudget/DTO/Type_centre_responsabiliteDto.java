package com.kripton.gestionbudget.DTO;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id_type_centre_responsabilite")
public class Type_centre_responsabiliteDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id_type_centre_responsabilite;
	@NotBlank
	private String libelle_type_centre_responsabilite;
	private List<Centre_responsabiliteDto> centres_responsabilite;
	public List<Centre_responsabiliteDto> getCentres_responsabilite() {
		return centres_responsabilite;
	}

	public void setCentres_responsabilite(List<Centre_responsabiliteDto> centres_responsabilite) {
		this.centres_responsabilite = centres_responsabilite;
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
