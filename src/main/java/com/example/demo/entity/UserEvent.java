package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="user_event")
public class UserEvent {

	@EmbeddedId
	private UserEventId userEventId=new UserEventId();
	
	@Column(name="hasRead")
	private boolean hasRead=false;

	@ManyToOne
	@MapsId("userId")
	private User user;
	
	@ManyToOne 
	@MapsId("eventId")
	private Event event;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public UserEventId getUserEventId() {
		return userEventId;
	}

	public void setUserEventId(UserEventId userEventId) {
		this.userEventId = userEventId;
	}

	public boolean isHasRead() {
		return hasRead;
	}

	public void setHasRead(boolean hasRead) {
		this.hasRead = hasRead;
	}
	
	
	
}
