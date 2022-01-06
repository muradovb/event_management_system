package com.example.demo.service;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.ElementNotFoundException;
import com.example.demo.entity.Event;
import com.example.demo.repository.EventRepository;


@Service
public class EventServiceImpl implements EventService{

	private EventRepository eventRepository;
	
	@Autowired
	public EventServiceImpl(EventRepository eventRepository) {
		this.eventRepository=eventRepository;
	}
	
	@Override
	public List<Event> findAll() {
		return eventRepository.findAll();
	}

	@Override
	public Event save(Event event) {
		 return eventRepository.save(event);
	}
	
	@Override
	public void deleteEvent(int eventId) {
		eventRepository.deleteById(eventId);
	}
	
	@Override
	public Event findEvent(int eventId) throws ElementNotFoundException{
		Event temp= eventRepository.findById(eventId).get();
		if(temp==null) {
			throw new ElementNotFoundException("element could not be found");
		}
		return temp;
	}


}
