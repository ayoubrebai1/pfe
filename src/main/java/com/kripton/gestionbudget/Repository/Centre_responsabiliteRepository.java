package com.kripton.gestionbudget.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kripton.gestionbudget.entities.Centre_responsabilite;
import com.kripton.gestionbudget.entities.User;

public interface Centre_responsabiliteRepository extends JpaRepository<Centre_responsabilite, Integer> {

	//public Centre_responsabilite  findByid_centre_responsabilite(Integer id_centre_responsabilite);
	  List<Centre_responsabilite> findByUser(User user);
}
