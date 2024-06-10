package com.kripton.gestionbudget.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kripton.gestionbudget.entities.Rubrique_budget;

public interface Rubrique_budgetRepository extends JpaRepository<Rubrique_budget, Integer> {

	
	Rubrique_budget findByLibelle(String libelle);
}
