package com.kripton.gestionbudget.Repository;

import com.kripton.gestionbudget.entities.Historique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriqueRepository extends JpaRepository<Historique,Long> {
}
