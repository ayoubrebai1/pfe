package com.kripton.gestionbudget.DTO;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.kripton.gestionbudget.entities.User;
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id_centre_responsabilite")

public class Centre_responsabiliteDto  {
    private Integer id_centre_responsabilite ;
    private String libelle_centre_responsabilite;
    //private List<BudgetDto> budgets;
    private Type_centre_responsabiliteDto type_centre_responsabilite ;
    private OrganigrammeDto organigramme;
    private User user;

	public Integer getId_centre_responsabilite(){
		return id_centre_responsabilite;
	}

	public void setId_centre_responsabilite(Integer id_centre_responsabilite) {
		this.id_centre_responsabilite = id_centre_responsabilite;
	}
	
	public String getLibelle_centre_responsabilite() {
		return libelle_centre_responsabilite;
	}

	public void setLibelle_centre_responsabilite(String libelle_centre_responsabilite) {
		this.libelle_centre_responsabilite = libelle_centre_responsabilite;
	}

	/*public List<BudgetDto> getBudgets() {
		return budgets;
	}

	public void setBudgets(List<BudgetDto> budgets) {
		this.budgets = budgets;
	}*/

	public Type_centre_responsabiliteDto getType_centre_responsabilite() {
		return type_centre_responsabilite;
	}

	public void setType_centre_responsabilite(Type_centre_responsabiliteDto type_centre_responsabilite) {
		this.type_centre_responsabilite = type_centre_responsabilite;
	}

	public OrganigrammeDto getOrganigramme() {
		return organigramme;
	}

	public void setOrganigramme(OrganigrammeDto organigramme) {
		this.organigramme = organigramme;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	
}
