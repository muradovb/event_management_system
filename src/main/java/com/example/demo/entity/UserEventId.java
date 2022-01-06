package com.example.demo.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class UserEventId implements Serializable{
	
	private int userId;
	private int eventId;
	 
	public UserEventId() {
		 
	}
	 
	public UserEventId(int userId, int eventId) {
	        super();
	        this.userId = userId;
	        this.eventId = eventId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	 

	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserEventId other = (UserEventId) obj;
        return Objects.equals(getEventId(), other.getEventId()) && Objects.equals(getUserId(), other.getUserId());
    }
	 
}
