package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Event;

public interface EventService {

	public List<Event> findAll();
	
	public Event findEvent(int id);
	
	public Event save(Event event);
	
	public void deleteEvent(int id);
}
