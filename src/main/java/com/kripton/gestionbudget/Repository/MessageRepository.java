package com.kripton.gestionbudget.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kripton.gestionbudget.entities.Message;

public interface MessageRepository extends JpaRepository<Message, Integer>{

}
