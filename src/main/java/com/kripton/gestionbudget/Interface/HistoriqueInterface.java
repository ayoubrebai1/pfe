package com.kripton.gestionbudget.Interface;

import com.kripton.gestionbudget.DTO.NodeDto;
import com.kripton.gestionbudget.entities.Historique;

import java.util.List;

public interface HistoriqueInterface {
    public Historique Add(Historique historique);
    public List<Historique> getAll();
}
