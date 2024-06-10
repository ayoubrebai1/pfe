package com.kripton.gestionbudget.Interface;

import java.util.List;


import com.kripton.gestionbudget.DTO.ProfileDto;

public interface ProfileInterface {

	public List<ProfileDto> getAll();
	public void Delete (ProfileDto profile);
	public ProfileDto Add(ProfileDto profile);
	public ProfileDto Update(ProfileDto profile);
	public ProfileDto getById(Integer id);
}
