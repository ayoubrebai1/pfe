package com.kripton.gestionbudget.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Message implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String contenue;
	private Date date = new Date();
	private String email;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="id_detail_budget")
	private Detail_budget detail_budget;
	public Detail_budget getDetail_budget() {
		return detail_budget;
	}
	public void setDetail_budget(Detail_budget detail_budget) {
		this.detail_budget = detail_budget;
	}
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(Integer id, String contenue) {
		super();
		Id = id;
		this.contenue = contenue;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getContenue() {
		return contenue;
	}
	public void setContenue(String contenue) {
		this.contenue = contenue;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Message(Integer id, String contenue, Date date, Detail_budget detail_budget) {
		super();
		Id = id;
		this.contenue = contenue;
		this.date = date;
		this.detail_budget = detail_budget;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Message(Integer id, String contenue, Date date, String email, Detail_budget detail_budget) {
		super();
		Id = id;
		this.contenue = contenue;
		this.date = date;
		this.email = email;
		this.detail_budget = detail_budget;
	}
	

}
