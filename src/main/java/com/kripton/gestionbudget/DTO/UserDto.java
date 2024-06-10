package com.kripton.gestionbudget.DTO;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import com.kripton.gestionbudget.entities.Centre_responsabilite;



public class UserDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id_user;
	@NotBlank(message="Ce champ ne doit etre null !")
	private String firstName;
	
	@NotNull(message="Ce champ ne doit etre null !")
	@Size(min=3, message="Ce champ doit avoir au moins 3 Caracteres !")
	private String lastName;
	
	@NotNull(message="Ce champ ne doit etre null !")
	@Email(message="ce champ doit respecter le format email !")
	private String email;
	private String role;
	@NotNull(message="Ce champ ne doit etre null !")
	@Size(min=8, message="mot de passe doit avoir au moins 8 caracteres !")
	@Pattern(regexp="(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$", message="ce mot de passe doit avoir des lettres en Maj et Minsc et numero")
	private String password;
	
	private Boolean status = true;
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
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
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
	
}
