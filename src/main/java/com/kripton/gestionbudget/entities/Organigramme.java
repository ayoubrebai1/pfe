package com.kripton.gestionbudget.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@Entity
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"hibernate_lazy_initializer", "handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id_organigramme")
public class Organigramme implements Serializable {

	public Organigramme(String id, String libelle, Organigramme organigramme, List<Organigramme> children) {
		super();
		this.id_organigramme = id;
		this.libelle = libelle;
		this.organigramme = organigramme;
		this.children = children;
	}
	private static final long serialVersionUID = 3345682963094132067L;
	@Id
    private String id_organigramme;
	@OneToOne(mappedBy = "organigramme", cascade = CascadeType.ALL)
	private Node node;
	private String libelle;
	private Date date;
	private Integer status;
	
	
	public Organigramme(String id_organigramme, Node node, String libelle, Date date, Integer status,
			Organigramme organigramme, List<Organigramme> children, List<Centre_responsabilite> centres_responsabilite,
			Type_organigramme type_organigramme) {
		super();
		this.id_organigramme = id_organigramme;
		this.node = node;
		this.libelle = libelle;
		this.date = date;
		this.status = status;
		this.organigramme = organigramme;
		this.children = children;
		this.centres_responsabilite = centres_responsabilite;
		this.type_organigramme = type_organigramme;
	}

	public List<Centre_responsabilite> getCentres_responsabilite() {
		return centres_responsabilite;
	}

	public void setCentres_responsabilite(List<Centre_responsabilite> centres_responsabilite) {
		this.centres_responsabilite = centres_responsabilite;
	}

	public Type_organigramme getType_organigramme() {
		return type_organigramme;
	}

	public void setType_organigramme(Type_organigramme type_organigramme) {
		this.type_organigramme = type_organigramme;
	}
	
	public Organigramme() {
		super();
		// TODO Auto-generated constructor stub
	}
	@ManyToOne (fetch = FetchType.LAZY) 
	@JoinColumn(name="id_parent")
	//@JsonBackReference
	private Organigramme organigramme;
	
	@OneToMany (fetch = FetchType.LAZY, mappedBy = "organigramme",cascade = CascadeType.ALL)
	//@JsonManagedReference
	private List<Organigramme> children;
	@OneToMany(mappedBy="organigramme", cascade=CascadeType.ALL)
	private List<Centre_responsabilite> centres_responsabilite;
	
	@ManyToOne(fetch = FetchType.LAZY,optional = true)
	@JoinColumn(name="id_type_organigramme",nullable=true)
	private Type_organigramme type_organigramme;
	


	

	public String getId_organigramme() {
		return id_organigramme;
	}

	public void setId_organigramme(String id_organigramme) {
		this.id_organigramme = id_organigramme;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Organigramme getOrganigramme() {
		return organigramme;
	}

	public void setOrganigramme(Organigramme organigramme) {
		this.organigramme = organigramme;
	}

	public Collection<Organigramme> getChildren() {
		return children;
	}
	@JsonIgnore 
	public void setChildren(List<Organigramme> children) {
		this.children = children;
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	public Organigramme(String id_organigramme, Node node, String libelle, Organigramme organigramme,
			List<Organigramme> children, List<Centre_responsabilite> centres_responsabilite,
			Type_organigramme type_organigramme) {
		super();
		this.id_organigramme = id_organigramme;
		this.node = node;
		this.libelle = libelle;
		this.organigramme = organigramme;
		this.children = children;
		this.centres_responsabilite = centres_responsabilite;
		this.type_organigramme = type_organigramme;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	

}



