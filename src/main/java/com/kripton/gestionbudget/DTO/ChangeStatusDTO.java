package com.kripton.gestionbudget.DTO;

public class ChangeStatusDTO {
	private Integer id_detail_budget;
	private  String status;
	public Integer getId_detail_budget() {
		return id_detail_budget;
	}
	public void setId_detail_budget(Integer id_detail_budget) {
		this.id_detail_budget = id_detail_budget;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
