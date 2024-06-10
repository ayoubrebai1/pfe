package com.kripton.gestionbudget.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kripton.gestionbudget.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);
}
