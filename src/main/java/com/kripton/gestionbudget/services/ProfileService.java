package com.kripton.gestionbudget.services;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kripton.gestionbudget.DTO.ProfileDto;
import com.kripton.gestionbudget.Interface.ProfileInterface;
import com.kripton.gestionbudget.Repository.ProfileRepository;
import com.kripton.gestionbudget.entities.Profile;
@Service
public class ProfileService implements ProfileInterface{

	@Autowired
	private ProfileRepository profileRepository;
	ModelMapper modelMapper = new ModelMapper();
	@Override
	public List<ProfileDto> getAll() {

		List<Profile> profile =  profileRepository.findAll();
		Type listType = new TypeToken<List<ProfileDto>>() {}.getType();
		List<ProfileDto> ListProfileDto = modelMapper.map(profile,listType);
		
		return ListProfileDto;
	}

	@Override
	public void Delete(ProfileDto profile) {

		//Profile profileEntity = modelMapper.map(profile, Profile.class);
		profileRepository.deleteById(profile.getId_profile());
	}

	@Override
	public ProfileDto Add(ProfileDto profile) {
		Profile profileEntity = modelMapper.map(profile, Profile.class);
		Profile newProfile = profileRepository.save(profileEntity);
		ProfileDto profileDto = modelMapper.map(newProfile, ProfileDto.class);
		return profileDto;
	}

	@Override
	public ProfileDto Update(ProfileDto profile) {
		Profile profileEntity = modelMapper.map(profile, Profile.class);
		Profile newProfile = profileRepository.save(profileEntity);
		ProfileDto profileDto = modelMapper.map(newProfile, ProfileDto.class);
		return profileDto;
	}

	@Override
	public ProfileDto getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
