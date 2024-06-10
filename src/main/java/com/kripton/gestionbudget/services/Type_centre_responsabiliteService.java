package com.kripton.gestionbudget.services;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kripton.gestionbudget.DTO.Type_centre_responsabiliteDto;
import com.kripton.gestionbudget.Interface.Type_centre_responsabiliteInterface;
import com.kripton.gestionbudget.Repository.Type_centre_responsabiliteRepository;
import com.kripton.gestionbudget.entities.Type_centre_responsabilite;
@Service
public class Type_centre_responsabiliteService implements Type_centre_responsabiliteInterface{

	@Autowired
	private Type_centre_responsabiliteRepository type_centre_responsabiliteRepository;

	ModelMapper modelMapper = new ModelMapper();
	@Override
	public List<Type_centre_responsabiliteDto> getAll() {
		List<Type_centre_responsabilite> listTypeCentreResponsabilite = type_centre_responsabiliteRepository.findAll();
		List<Type_centre_responsabiliteDto> listDto = new ArrayList<Type_centre_responsabiliteDto>();
		for(Type_centre_responsabilite centre: listTypeCentreResponsabilite) {
			Type_centre_responsabiliteDto NDto = modelMapper.map(centre,Type_centre_responsabiliteDto.class);
			listDto.add(NDto);
		}
	
		return listDto;
		
	}

	@Override
	public void Delete(Type_centre_responsabiliteDto type_centre_responsabilite) {
		//Type_centre_responsabilite typeCentreResponsabilite = modelMapper.map(type_centre_responsabilite, Type_centre_responsabilite.class);
		type_centre_responsabiliteRepository.deleteById(type_centre_responsabilite.getId_type_centre_responsabilite());
		
	}

	@Override
	public Type_centre_responsabiliteDto Add(Type_centre_responsabiliteDto typeCentre) {
		Type_centre_responsabilite typeCentreResponsabilite = modelMapper.map(typeCentre, Type_centre_responsabilite.class);
		Type_centre_responsabilite newType = type_centre_responsabiliteRepository.save(typeCentreResponsabilite);
		Type_centre_responsabiliteDto newTypeDto = modelMapper.map(newType, Type_centre_responsabiliteDto.class);
		return newTypeDto;
	}

	@Override
	public Type_centre_responsabiliteDto Update(Type_centre_responsabiliteDto typeCentre) {
		Type_centre_responsabilite typeCentreResponsabilite = modelMapper.map(typeCentre, Type_centre_responsabilite.class);
		Type_centre_responsabilite newType = type_centre_responsabiliteRepository.save(typeCentreResponsabilite);
		Type_centre_responsabiliteDto newTypeDto = modelMapper.map(newType, Type_centre_responsabiliteDto.class);
		return newTypeDto;
	}

	@Override
	public Type_centre_responsabiliteDto getById(Integer Id) {
		Type_centre_responsabilite typeCentreResponsabilite = type_centre_responsabiliteRepository.findById(Id).get();
		Type_centre_responsabiliteDto newTypeDto = modelMapper.map(typeCentreResponsabilite, Type_centre_responsabiliteDto.class);
		return newTypeDto;
	}
	
}
