package com.kripton.gestionbudget.security;

import com.kripton.gestionbudget.Repository.HistoriqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StaticHistoricHolder {
    public static HistoriqueRepository historiqueRepository;

    @Autowired
    public void setHistoriqueRepository(HistoriqueRepository historiqueRepository){
        StaticHistoricHolder.historiqueRepository = historiqueRepository;
    }
}
