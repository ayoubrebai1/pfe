package com.kripton.gestionbudget.Interface;

import java.util.List;

import com.kripton.gestionbudget.DTO.MessageDto;


public interface MessageInterface {
	
	public List<MessageDto> getAll();
	public void delete(MessageDto msg);
	public MessageDto Add(MessageDto msg);
	public MessageDto Update(MessageDto msg);
	
	

}
