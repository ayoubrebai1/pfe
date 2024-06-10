package com.kripton.gestionbudget.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class Node implements Serializable {

	private static final long serialVersionUID = 1627384312231736921L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Shape shape;
	private Integer height;
	private Integer width;
	private Style style;
	private Integer offsetX;
	private Integer offsetY;
	@OneToOne
	@JoinColumn(name = "id_organigramme")
	private Organigramme organigramme;
	public Organigramme getOrganigramme() {
		return organigramme;
	}
	public void setOrganigramme(Organigramme organigramme) {
		this.organigramme = organigramme;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Shape getShape() {
		return shape;
	}
	public void setShape(Shape shape) {
		this.shape = shape;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public Style getStyle() {
		return style;
	}
	public void setStyle(Style style) {
		this.style = style;
	}
	public Node(Integer id, Shape shape, Integer height, Integer width, Style style) {
		super();
		this.id = id;
		this.shape = shape;
		this.height = height;
		this.width = width;
		this.style = style;
	}
	public Node() {
		super();
		
	}
	public Integer getOffsetX() {
		return offsetX;
	}
	public void setOffsetX(Integer offsetX) {
		this.offsetX = offsetX;
	}
	public Integer getOffsetY() {
		return offsetY;
	}
	public void setOffsetY(Integer offsetY) {
		this.offsetY = offsetY;
	}
	public Node(Integer id, Shape shape, Integer height, Integer width, Style style, Integer offsetX, Integer offsetY,
			Organigramme organigramme) {
		super();
		this.id = id;
		this.shape = shape;
		this.height = height;
		this.width = width;
		this.style = style;
		this.offsetX = offsetX;
		this.offsetY = offsetY;
		this.organigramme = organigramme;
	}

}
