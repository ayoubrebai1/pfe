package com.kripton.gestionbudget.DTO;

import java.util.Date;


import com.kripton.gestionbudget.entities.Detail_budget;
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class MessageDto {
	private Integer Id;
	private String contenue;
	private Detail_budget detail_budget;
	private Date date;
	private String email;
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
	public Detail_budget getDetail_budget() {
		return detail_budget;
	}
	public void setDetail_budget(Detail_budget detail_budget) {
		this.detail_budget = detail_budget;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
