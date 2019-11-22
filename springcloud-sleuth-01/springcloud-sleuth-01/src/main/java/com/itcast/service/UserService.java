package com.itcast.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class UserService {
	
	private Logger logger = LoggerFactory.getLogger(UserService.class);
	
	public void sayUser(){
		logger.info("Doing some work");
	}

}
