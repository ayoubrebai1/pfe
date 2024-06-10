package com.kripton.gestionbudget.Interface;


import java.util.List;

import com.kripton.gestionbudget.DTO.Type_centre_responsabiliteDto;


public interface Type_centre_responsabiliteInterface  {
	public List<Type_centre_responsabiliteDto> getAll();
	public void Delete(Type_centre_responsabiliteDto type_centre_responsabilite);
	public Type_centre_responsabiliteDto Add(Type_centre_responsabiliteDto typeCentre);
    public Type_centre_responsabiliteDto Update(Type_centre_responsabiliteDto typeCentre);
    public Type_centre_responsabiliteDto getById(Integer Id);

}
