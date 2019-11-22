package com.itcast.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class XController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	
	 @Autowired
	    private RestTemplate restTemplate;



	    @RequestMapping("/hello")
	    public String hello(){
	        logger.info("calling trace server-x ");
	        return restTemplate.getForObject("http://localhost:8093/info", String.class);
	    }
	    @RequestMapping("/info")
	    public String info(){
	        logger.info("calling trace server-x ");
	        return "i'm server-x";
	    }
}
