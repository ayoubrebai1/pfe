package com.kripton.gestionbudget.DTO;

import java.util.Date;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonFormat;


public class OrganigrammeDto  {
	
	private String id_organigramme;
	private String libelle;
	//@JsonBackReference
	private OrganigrammeDto organigramme;
	private Type_organigrammeDto type_organigramme;
	//private List<Centre_responsabiliteDto> centres_responsabilite;
	//private NodeDto node;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date date = new Date();
	private Integer status = 0;
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
	//@JsonManagedReference
	//private List<OrganigrammeDto> children;
	public String getId_organigramme() {
		return id_organigramme;
	}
	public void setId_organigramme(String id_organigramme) {
		this.id_organigramme = id_organigramme;
	}
	public OrganigrammeDto getOrganigramme() {
		return organigramme;
	}
	public void setOrganigramme(OrganigrammeDto organigramme) {
		this.organigramme = organigramme;
	}
	public Type_organigrammeDto getType_organigramme() {
		return type_organigramme;
	}
	public void setType_organigramme(Type_organigrammeDto type_organigramme) {
		this.type_organigramme = type_organigramme;
	}
	//public List<Centre_responsabiliteDto> getCentres_responsabilite() {
	//	return centres_responsabilite;
//	}
//	public void setCentres_responsabilite(List<Centre_responsabiliteDto> centres_responsabilite) {
//		this.centres_responsabilite = centres_responsabilite;
//	}
//	public NodeDto getNode() {
//		return node;
//	}
//	public void setNode(NodeDto node) {
//		this.node = node;
//	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
//	public List<OrganigrammeDto> getChildren() {
//		return children;
//	}
//	public void setChildren(List<OrganigrammeDto> children) {
//		this.children = children;
//	}
}