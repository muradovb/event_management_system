package com.example.demo.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Event;
import com.example.demo.service.EventService;
import com.example.demo.service.UserEventService;


@RestController
@RequestMapping("/api")
public class MainController {

	
	private EventService eventService;
	private UserEventService userEventService;
	
	@Autowired
	public MainController(EventService eventService) {
		this.eventService=eventService;
	}
	
	//event related endpoints
	
	@GetMapping("/readEvents")
	public List<Event> readEvents(@RequestParam int userId){

		//get events
		List<Event> eventsList= eventService.findAll();
		
		//mark events read for user
		for(Event evt:eventsList) {
			userEventService.markEventAsRead(evt.getEventId(), userId);
		}
		
		//return list of events
		return eventsList;
	}
	
	@GetMapping("/readEvent/{eventId}")
	public Event readEvent(@PathVariable int eventId, @RequestParam int userId) {
		//get Event
		Event evt= eventService.findEvent(eventId);
		
		//mark event read for user
		userEventService.markEventAsRead(eventId, userId);
		
		//return event
		return evt;
		
	}
	
	@GetMapping("/getEvents")
	public List<Event> getEvents(){
		return eventService.findAll();
	}
	
	
	@PostMapping("/addEvent")
	public ResponseEntity<String> addProduct(@RequestBody Event event) {
		try {
			Event temp=eventService.save(event);
			String eventName=temp.getEventName();
			return new ResponseEntity<>("Uploaded event: "+eventName+" successfully", HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed to upload event", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	
	@PutMapping("/editEvent/{eventId}")
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> editEvent(@PathVariable int eventId, @RequestBody Event event) {
		try {
			event.setEventId(eventId);
			eventService.save(event);
			return new ResponseEntity<>("Updated event with id: "+eventId+" successfully", HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed to update event", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/deleteEvent/{eventId}")
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteEvent(@PathVariable int eventId) {
		try {
			eventService.deleteEvent(eventId);
			return new ResponseEntity<>("Deleted event with id: "+eventId+" successfully", HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed to delete event", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	
	
	
	
}
