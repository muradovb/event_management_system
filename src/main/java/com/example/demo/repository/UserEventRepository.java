package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Event;
import com.example.demo.entity.UserEvent;
import com.example.demo.entity.UserEventId;

public interface UserEventRepository extends JpaRepository<UserEvent, UserEventId>{

	
	
}
