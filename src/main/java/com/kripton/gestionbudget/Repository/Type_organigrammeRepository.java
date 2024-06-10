package com.kripton.gestionbudget.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kripton.gestionbudget.entities.Type_organigramme;
public interface Type_organigrammeRepository extends JpaRepository<Type_organigramme, Integer> {

	//public Type_organigramme  findById_type_organigramme(Integer id_type_organigramme);
}
