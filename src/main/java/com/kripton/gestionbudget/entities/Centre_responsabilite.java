package com.kripton.gestionbudget.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id_centre_responsabilite")

public class Centre_responsabilite implements Serializable {
	
	private static final long serialVersionUID = -3115990395025804604L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_centre_responsabilite ;
	
	private String libelle_centre_responsabilite;
	@OneToMany(mappedBy="centre_responsabilite", cascade=CascadeType.ALL)
	//@JsonManagedReference
	private List<Budget> budgets;
	@ManyToOne
	@JoinColumn(name="id_type_centre_responsabilite")
	private Type_centre_responsabilite type_centre_responsabilite ;
	@ManyToOne
    @JoinColumn(name="id_organigramme")
    private Organigramme organigramme;
    @OneToOne(mappedBy="centre", cascade=CascadeType.ALL)
    private User user;

	public Centre_responsabilite(Integer id_centre_responsabilite, String libelle_centre_responsabilite) {
		super();
		this.id_centre_responsabilite = id_centre_responsabilite;
		this.libelle_centre_responsabilite = libelle_centre_responsabilite;
	}

	public Centre_responsabilite() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId_centre_responsabilite() {
		return id_centre_responsabilite;
	}

	public void setId_centre_responsabilite(Integer id_centre_responsabilite) {
		this.id_centre_responsabilite = id_centre_responsabilite;
	}

	public String getLibelle_centre_responsabilite() {
		return libelle_centre_responsabilite;
	}

	public List<Budget> getBudgets() {
		return budgets;
	}

	public void setBudgets(List<Budget> budgets) {
		this.budgets = budgets;
	}

	public Type_centre_responsabilite getType_centre_responsabilite() {
		return type_centre_responsabilite;
	}

	public void setType_centre_responsabilite(Type_centre_responsabilite type_centre_responsabilite) {
		this.type_centre_responsabilite = type_centre_responsabilite;
	}

	

	public void setLibelle_centre_responsabilite(String libelle_centre_responsabilite) {
		this.libelle_centre_responsabilite = libelle_centre_responsabilite;
	}

	public Organigramme getOrganigramme() {
		return organigramme;
	}

	public void setOrganigramme(Organigramme organigramme) {
		this.organigramme = organigramme;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Centre_responsabilite(Integer id_centre_responsabilite, String libelle_centre_responsabilite,
			List<Budget> budgets, Type_centre_responsabilite type_centre_responsabilite, Organigramme organigramme,
			User user) {
		super();
		this.id_centre_responsabilite = id_centre_responsabilite;
		this.libelle_centre_responsabilite = libelle_centre_responsabilite;
		this.budgets = budgets;
		this.type_centre_responsabilite = type_centre_responsabilite;
		this.organigramme = organigramme;
		this.user = user;
	}

	
}
