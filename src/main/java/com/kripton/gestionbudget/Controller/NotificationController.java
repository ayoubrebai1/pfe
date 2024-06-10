package com.kripton.gestionbudget.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kripton.gestionbudget.Repository.NotificationRepository;
import com.kripton.gestionbudget.entities.Notification;

@RestController
@RequestMapping("/notification")
public class NotificationController {

	@Autowired 
	private NotificationRepository notRep;
	
	@GetMapping
	public List<Notification> getAll(){
		return notRep.findAll();
	}
	@PostMapping
	public Notification save(@RequestBody Notification notification) {
		
		  return notRep.save(notification);
		
	}
}
