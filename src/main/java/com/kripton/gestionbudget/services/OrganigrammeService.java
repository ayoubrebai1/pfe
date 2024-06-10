package com.kripton.gestionbudget.services;


import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kripton.gestionbudget.DTO.OrganigrammeDto;
import com.kripton.gestionbudget.Interface.OrganigrammeInterface;
import com.kripton.gestionbudget.Repository.OrganigrammeRepository;
import com.kripton.gestionbudget.entities.Organigramme;
@Service
public class OrganigrammeService implements OrganigrammeInterface {
	
	@Autowired
	private OrganigrammeRepository organigrammeRepository;
	
	ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<OrganigrammeDto> getAll() {

		List<Organigramme> listOrganigramme = organigrammeRepository.findAll();
		List<OrganigrammeDto> listDto = new ArrayList<OrganigrammeDto>();
		for(Organigramme organigramme: listOrganigramme) {
			OrganigrammeDto NDto = modelMapper.map(organigramme,OrganigrammeDto.class);
			listDto.add(NDto);
		}
	
		return listDto;
	}

	@Override
	public void Delete(OrganigrammeDto organigrameDto) {
		Organigramme organigramme = modelMapper.map(organigrameDto, Organigramme.class);
		organigrammeRepository.delete(organigramme);
		
	}

	@Override
	public String Add(ArrayList<OrganigrammeDto> organigrameDto) {
		
		
		for (OrganigrammeDto organigrammeDto : organigrameDto) {
			try {
				Organigramme organigramme = modelMapper.map(organigrammeDto, Organigramme.class);
				 organigrammeRepository.save(organigramme);
			}
			catch(Exception e ) {
				System.out.println(e.toString());
			}
		}
		
		/*java.util.Optional<Organigramme> orga = organigrammeRepository.findById(organigrameDto.getId_organigramme());
		if(orga.isPresent()) throw new RuntimeException("organigramme existe");
		if(organigrameDto.getNode() != null) {
			organigrameDto.getNode().setOrganigramme(organigrameDto);
		}
		
		Organigramme organigramme = modelMapper.map(organigrameDto, Organigramme.class);
		Organigramme newOrganigramme = organigrammeRepository.save(organigramme);
		OrganigrammeDto organigrammeDto = modelMapper.map(newOrganigramme, OrganigrammeDto.class);
		return organigrammeDto;*/
		return "success";
	}

	@Override
	public OrganigrammeDto Update(OrganigrammeDto organigrameDto){
		Organigramme organigramme = modelMapper.map(organigrameDto, Organigramme.class);
		Organigramme newOrganigramme = organigrammeRepository.save(organigramme);
		OrganigrammeDto organigrammeDto = modelMapper.map(newOrganigramme, OrganigrammeDto.class);
		return organigrammeDto;
		}

	@Override
	public OrganigrammeDto getById(String id) {
		Organigramme organigramme =organigrammeRepository.findById(id).get();
		OrganigrammeDto organigrammeDto = modelMapper.map(organigramme, OrganigrammeDto.class);
		return organigrammeDto;
	}

}
