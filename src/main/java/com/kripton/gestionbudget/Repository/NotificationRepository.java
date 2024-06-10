package com.kripton.gestionbudget.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kripton.gestionbudget.entities.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {

}
