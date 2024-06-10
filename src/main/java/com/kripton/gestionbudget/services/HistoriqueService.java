package com.kripton.gestionbudget.services;

import com.kripton.gestionbudget.DTO.NodeDto;
import com.kripton.gestionbudget.Interface.HistoriqueInterface;
import com.kripton.gestionbudget.Repository.HistoriqueRepository;
import com.kripton.gestionbudget.entities.Historique;
import com.kripton.gestionbudget.entities.Node;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class HistoriqueService implements HistoriqueInterface {
@Autowired
    private HistoriqueRepository historiqueRepo;
    ModelMapper modelMapper = new ModelMapper();




    @Override
    public Historique Add(Historique historique) {

        return this.historiqueRepo.save(historique);
    }
    @Override
    public List<Historique> getAll() {

        List<Historique> histos = historiqueRepo.findAll();
        Type listType = new TypeToken<List<Historique>>() {}.getType();
        List<Historique> listHisto = modelMapper.map(histos,listType);
        return listHisto;
    }
}
