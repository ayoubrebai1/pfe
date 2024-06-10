package com.kripton.gestionbudget.Controller;

import com.kripton.gestionbudget.DTO.NodeDto;
import com.kripton.gestionbudget.entities.Historique;
import com.kripton.gestionbudget.services.HistoriqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/historique")
public class HistoriqueController {
    @Autowired
    private HistoriqueService historiqueService;
    @GetMapping
    public ResponseEntity<List<Historique>> getAllHistorique(){
        List<Historique> historiques = historiqueService.getAll();
        return new ResponseEntity<List<Historique>>(historiques, HttpStatus.OK);
    }
}
