package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.UserEvent;
import com.example.demo.entity.UserEventId;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.UserEventRepository;

public class UserEventServiceImpl implements UserEventService{

	private UserEventRepository userEventRepository;
	
	@Autowired
	public UserEventServiceImpl(UserEventRepository userEventRepository) {
		this.userEventRepository=userEventRepository;
	}
	
	@Override
	public void markEventAsRead(int eventId, int userId) {
		UserEventId userEventId= new UserEventId(eventId, userId);
		UserEvent userEvent=new UserEvent();
		userEvent.setUserEventId(userEventId);
		userEvent.setHasRead(true);
		userEventRepository.save(userEvent);
	}

}
