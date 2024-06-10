package com.kripton.gestionbudget.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kripton.gestionbudget.DTO.MessageDto;
import com.kripton.gestionbudget.Interface.MessageInterface;
import com.kripton.gestionbudget.Repository.MessageRepository;
import com.kripton.gestionbudget.entities.Message;

@Service
public class MessageService implements MessageInterface{
	
	@Autowired 
	private MessageRepository msgRepository;
	ModelMapper modelMapper = new ModelMapper();
	@Override
	public List<MessageDto> getAll() {
		List<Message> listMsg = msgRepository.findAll();
		List<MessageDto> listDto = new  ArrayList<MessageDto>();
		for(Message msg:listMsg) {
			MessageDto msgDto = modelMapper.map(msg,MessageDto.class);
			listDto.add(msgDto);
		}
		return listDto;
	}

	@Override
	public void delete(MessageDto msg) {
		
		msgRepository.deleteById(msg.getId());
	}

	@Override
	public MessageDto Add(MessageDto msg) {
		Message msgEntity = modelMapper.map(msg,Message.class);
		Message newMsg = msgRepository.save(msgEntity);
		MessageDto msgDto = modelMapper.map(newMsg, MessageDto.class);
		return msgDto;
	}

	@Override
	public MessageDto Update(MessageDto msg) {
		Message msgEntity = modelMapper.map(msg,Message.class);
		Message newMsg = msgRepository.save(msgEntity);
		MessageDto msgDto = modelMapper.map(newMsg, MessageDto.class);
		return msgDto;
	}

}
