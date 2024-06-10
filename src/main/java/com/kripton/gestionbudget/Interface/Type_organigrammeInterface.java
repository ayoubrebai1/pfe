package com.kripton.gestionbudget.Interface;

import java.util.List;

import com.kripton.gestionbudget.DTO.Type_organigrammeDto;

public interface Type_organigrammeInterface {
	public List<Type_organigrammeDto> getAll();
	public Type_organigrammeDto Add(Type_organigrammeDto typeOrganigrame);
	public void Delete(Type_organigrammeDto typeOrganigramme);
	public Type_organigrammeDto Update(Type_organigrammeDto typeOrganigramme);
	public Type_organigrammeDto getById(Integer id);

}
