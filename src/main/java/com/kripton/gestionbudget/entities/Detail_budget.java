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


import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id_detail_budget")

public class Detail_budget implements Serializable {

	
	private static final long serialVersionUID = -8475912753559572400L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_detail_budget;
	private  String libelle;
	private  String status;
	private String argument;
	private float montant_detail_budget;
	@ManyToOne
	@JoinColumn(name="id_budget")
	private Budget budget ;
	//@JsonBackReference
	@ManyToOne
	@JoinColumn(name="id_rubrique")
	private Rubrique_budget rubrique_budget ;
	@JsonManagedReference
    @OneToMany(mappedBy="detail_budget", cascade=CascadeType.ALL)
    private List<Message> messages;
    
	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Detail_budget(Integer id_detail_budget, String libelle, String status, String argument,
			float montant_detail_budget, Budget budget, Rubrique_budget rubrique_budget) {
		super();
		this.id_detail_budget = id_detail_budget;
		this.libelle = libelle;
		this.status = status;
		this.argument = argument;
		this.montant_detail_budget = montant_detail_budget;
		this.budget = budget;
		this.rubrique_budget = rubrique_budget;
	}

	public Budget getBudget() {
		return budget;
	}

	public void setBudget(Budget budget) {
		this.budget = budget;
	}

	public Rubrique_budget getRubrique_budget() {
		return rubrique_budget;
	}

	public void setRubrique_budget(Rubrique_budget rubrique_budget) {
		this.rubrique_budget = rubrique_budget;
	}

	public Detail_budget(Integer id_detail_budget, float montant_detail_budget) {
		super();
		this.id_detail_budget = id_detail_budget;
		this.montant_detail_budget = montant_detail_budget;
	}

	public Detail_budget() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId_detail_budget() {
		return id_detail_budget;
	}

	public void setId_detail_budget(Integer id_detail_budget) {
		this.id_detail_budget = id_detail_budget;
	}

	public float getMontant_detail_budget() {
		return montant_detail_budget;
	}

	public void setMontant_detail_budget(float montant_detail_budget) {
		this.montant_detail_budget = montant_detail_budget;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	public String getArgument() {
		return argument;
	}

	public void setArgument(String argument) {
		this.argument = argument;
	}

	
}
