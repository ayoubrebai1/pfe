package com.kripton.gestionbudget.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id_user")

public class User implements Serializable {

	private static final long serialVersionUID = -2613271326589299030L;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	public User(Integer id_user, String firstName, String lastName, String email, String role, String encryptedPassword,
			Boolean status) {
		super();
		this.id_user = id_user;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		this.encryptedPassword = encryptedPassword;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_user;
	
	@Column(nullable=false, length=50)
	private String firstName;
	
	@Column(nullable=false, length=50)
	private String lastName;
	
	@Column(nullable=false, unique=true)
	private String email;
	
	@Column(nullable=true)
	private String role ;
	
	@Column(nullable=false)
	private String encryptedPassword;
	@Column(nullable=false)
	private Boolean status = true;
	
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="centre_id")
	private Centre_responsabilite centre;

	public Integer getId_user() {
		return id_user;
	}

	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}



	public Centre_responsabilite getCentre() {
		return centre;
	}



	public void setCentre(Centre_responsabilite centre) {
		this.centre = centre;
	}



	public User(Integer id_user, String firstName, String lastName, String email, String role, String encryptedPassword,
			Boolean status, Centre_responsabilite centre) {
		super();
		this.id_user = id_user;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		this.encryptedPassword = encryptedPassword;
		this.status = status;
		this.centre = centre;
	}

}
