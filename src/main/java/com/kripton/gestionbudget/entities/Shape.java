package com.kripton.gestionbudget.entities;

import java.io.Serializable;

public class Shape implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7886628875044722422L;
	private String type;
	private String shape;
	public Shape() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Shape(String type, String shape) {
		super();
		this.type = type;
		this.shape = shape;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getShape() {
		return shape;
	}
	public void setShape(String shape) {
		this.shape = shape;
	}
}
