/*package com.kripton.gestionbudget;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
@RestController
@RequestMapping("/stream")
public abstract class NotificationController {
	public static final List<SseEmitter> emitters = Collections.synchronizedList( new ArrayList<>());
	 
	    @GetMapping( consumes = org.springframework.http.MediaType.ALL_VALUE)
	    public SseEmitter stream() throws IOException {

	        SseEmitter emitter = new SseEmitter();
	        //emitter.send(SseEmitter.event().name("im"));
	        emitters.add(emitter);
	        emitter.onCompletion(() -> emitters.remove(emitter));

	        return emitter;
	    }
	    @PostMapping("/add")
	    public void send(@RequestBody String msg) {
	    	for(SseEmitter s:emitters) {
	    		try {
					s.send(SseEmitter.event().name("test").data(msg));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    }
}*/
