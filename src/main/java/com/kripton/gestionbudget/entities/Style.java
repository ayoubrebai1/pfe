package com.kripton.gestionbudget.entities;

import java.io.Serializable;

public class Style implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7493705754393145766L;
	private String fill;

	public Style(String fill) {
		super();
		this.fill = fill;
	}

	public Style() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getFill() {
		return fill;
	}

	public void setFill(String fill) {
		this.fill = fill;
	}

	

}
