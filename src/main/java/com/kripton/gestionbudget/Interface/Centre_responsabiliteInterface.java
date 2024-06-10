package com.kripton.gestionbudget.Interface;


import java.util.List;

import com.kripton.gestionbudget.DTO.Centre_responsabiliteDto;
import com.kripton.gestionbudget.entities.Centre_responsabilite;


public interface Centre_responsabiliteInterface {
	public List<Centre_responsabilite> getAll(String email);
	public void Delete (Centre_responsabiliteDto centre_responsabilite);
	public Centre_responsabiliteDto Add(Centre_responsabiliteDto c);
	public Centre_responsabiliteDto Update(Centre_responsabiliteDto c);
	public Centre_responsabiliteDto getById(Integer id_centre_responsabilite);

}
