package com.kripton.gestionbudget.services;


import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kripton.gestionbudget.DTO.BudgetDto;
import com.kripton.gestionbudget.DTO.Centre_responsabiliteDto;
import com.kripton.gestionbudget.Interface.Centre_responsabiliteInterface;
import com.kripton.gestionbudget.Repository.Centre_responsabiliteRepository;
import com.kripton.gestionbudget.Repository.UserRepository;
import com.kripton.gestionbudget.entities.Centre_responsabilite;
import com.kripton.gestionbudget.entities.User;


@Service
public class Centre_responsabiliteService implements Centre_responsabiliteInterface {

	@Autowired
	private Centre_responsabiliteRepository centre_responsabiliteRepository;
	@Autowired
	private UserRepository userRepository;
	ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<Centre_responsabilite> getAll(String email) {
		
		User user = userRepository.findByEmail(email);
		if(user.getRole().equals("ADMIN")) {
			List<Centre_responsabilite> centreResponsabilites =  centre_responsabiliteRepository.findAll();
			List<Centre_responsabiliteDto> ListCentreResponsabilite = new ArrayList<Centre_responsabiliteDto>();
			
			/*for(Centre_responsabilite centre: centreResponsabilites) {
				Centre_responsabiliteDto CDto = modelMapper.map(centre,Centre_responsabiliteDto.class);
				ListCentreResponsabilite.add(CDto);
			}*/
			return centreResponsabilites;
		}
		else {
			List<Centre_responsabilite> ListCentreResponsabilite = new ArrayList<Centre_responsabilite>();
			Centre_responsabiliteDto CDto = modelMapper.map(user.getCentre(),Centre_responsabiliteDto.class);
			ListCentreResponsabilite.add(user.getCentre());
			return ListCentreResponsabilite;
		}
		
	}

	@Override
	public void Delete(Centre_responsabiliteDto centre_responsabilite) {
		//Centre_responsabilite centre = modelMapper.map(centre_responsabilite, Centre_responsabilite.class);
		centre_responsabiliteRepository.deleteById(centre_responsabilite.getId_centre_responsabilite());
		
	}

	@Override
	public Centre_responsabiliteDto Add(Centre_responsabiliteDto centre_responsabilite) {
	/*	
		if(centre_responsabilite.getBudgets()!= null) {
		for(int i =0; i< centre_responsabilite.getBudgets().size(); i++) {
			BudgetDto budget = centre_responsabilite.getBudgets().get(i);
			budget.setCentre_responsabilite(centre_responsabilite);
		}
		}
		Centre_responsabilite centre = modelMapper.map(centre_responsabilite, Centre_responsabilite.class);
		Centre_responsabilite newCentre = centre_responsabiliteRepository.save(centre);
		Centre_responsabiliteDto centreDto = modelMapper.map(newCentre, Centre_responsabiliteDto.class);
		return centreDto;
		*/
		return null;
	}

	@Override
	public Centre_responsabiliteDto Update(Centre_responsabiliteDto centre_responsabilite) {
		Centre_responsabilite centre = modelMapper.map(centre_responsabilite, Centre_responsabilite.class);
		Centre_responsabilite newCentre = centre_responsabiliteRepository.save(centre);
		Centre_responsabiliteDto centreDto = modelMapper.map(newCentre, Centre_responsabiliteDto.class);
		return centreDto;
	}

	@Override
	public Centre_responsabiliteDto getById(Integer id_centre_responsabilite) {
		Centre_responsabilite centre = centre_responsabiliteRepository.findById(id_centre_responsabilite).get();
		Centre_responsabiliteDto centreDto = modelMapper.map(centre, Centre_responsabiliteDto.class);
		
		return centreDto;
	}
	
	

}
