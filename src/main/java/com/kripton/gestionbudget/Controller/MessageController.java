package com.kripton.gestionbudget.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kripton.gestionbudget.DTO.MessageDto;
import com.kripton.gestionbudget.Interface.MessageInterface;

@RestController
@RequestMapping("/message")
public class MessageController {

	@Autowired
	private MessageInterface msgInterface;
	
	@GetMapping
      ResponseEntity<List<MessageDto>> getListMessage() {
		
		List<MessageDto> listMessage = msgInterface.getAll();
		return new ResponseEntity<List<MessageDto>>(listMessage, HttpStatus.OK);
	}
	@DeleteMapping
	ResponseEntity<Object> DeleteMessage(@RequestBody MessageDto msg){
		
		msgInterface.delete(msg);
		return new ResponseEntity<>( HttpStatus.NO_CONTENT);
	}
	@PostMapping
	public ResponseEntity<MessageDto> AddMessage(@RequestBody  MessageDto msg) {

		
		MessageDto createMessage =  msgInterface.Add(msg);
		
		
		return new ResponseEntity<MessageDto>(createMessage, HttpStatus.CREATED);

	}
}
