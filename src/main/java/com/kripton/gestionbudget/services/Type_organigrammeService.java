package com.kripton.gestionbudget.services;
import java.lang.reflect.Type;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kripton.gestionbudget.DTO.Type_organigrammeDto;
import com.kripton.gestionbudget.Interface.Type_organigrammeInterface;
import com.kripton.gestionbudget.Repository.Type_organigrammeRepository;
import com.kripton.gestionbudget.entities.Type_organigramme;
@Service
public class Type_organigrammeService implements Type_organigrammeInterface {
	@Autowired
	private Type_organigrammeRepository type_organigrammeRepository;
	ModelMapper modelMapper = new ModelMapper();
    
	@Override
	public List<Type_organigrammeDto> getAll() {
		
		List<Type_organigramme> listTypeOrganigramme = type_organigrammeRepository.findAll();
		Type listType = new TypeToken<List<Type_organigrammeDto>>() {}.getType();
		List<Type_organigrammeDto> listDto = modelMapper.map(listTypeOrganigramme,listType);
		return listDto;
	}
																												
	@Override
	public Type_organigrammeDto Add(Type_organigrammeDto typeOrganigramme) {
		
		java.util.Optional<Type_organigramme> t = type_organigrammeRepository.findById(typeOrganigramme.getId_type_organigramme());
		if(t.isPresent()) throw new RuntimeException("organigramme existe");
		Type_organigramme type = modelMapper.map(typeOrganigramme, Type_organigramme.class);
		Type_organigramme newType = type_organigrammeRepository.save(type);
		Type_organigrammeDto typeDto = modelMapper.map(newType, Type_organigrammeDto.class);
		return typeDto;
	}

	@Override
	public void Delete(Type_organigrammeDto typeOrganigramme) {
		Type_organigramme type = modelMapper.map(typeOrganigramme, Type_organigramme.class);
		type_organigrammeRepository.delete(type);

	}

	@Override
	public Type_organigrammeDto Update(Type_organigrammeDto typeOrganigramme) {
		Type_organigramme type = modelMapper.map(typeOrganigramme, Type_organigramme.class);
		Type_organigramme newType = type_organigrammeRepository.save(type);
		Type_organigrammeDto typeDto = modelMapper.map(newType, Type_organigrammeDto.class);
		return typeDto;
	}
             
	@Override
	public Type_organigrammeDto getById(Integer id){
		Type_organigramme type = type_organigrammeRepository.findById(id).get();
		Type_organigrammeDto typeDto = modelMapper.map(type, Type_organigrammeDto.class);
		return typeDto;
	}
}