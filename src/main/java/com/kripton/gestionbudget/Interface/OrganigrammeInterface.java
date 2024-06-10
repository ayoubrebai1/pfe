package com.kripton.gestionbudget.Interface;

import java.util.ArrayList;
import java.util.List;

import com.kripton.gestionbudget.DTO.OrganigrammeDto;


public interface OrganigrammeInterface {
	
	public List<OrganigrammeDto> getAll();
	public void Delete(OrganigrammeDto organigrameDto);
	public String Add(ArrayList<OrganigrammeDto> organigrameDto);
	public OrganigrammeDto Update(OrganigrammeDto organigrameDto);
	public OrganigrammeDto getById(String id);
	

}
