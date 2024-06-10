package com.kripton.gestionbudget.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kripton.gestionbudget.entities.Budget;

public interface BudgetRepository extends JpaRepository<Budget, Integer> {

}
