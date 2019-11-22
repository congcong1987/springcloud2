package com.itcast.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class YController {
	private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hello")
    public String hello(){
        logger.info("calling trace server-y ");
        return restTemplate.getForObject("http://localhost:8092/info", String.class);
    }
    @RequestMapping("/info")
    public String info(){
        logger.info("calling trace server-y ");
        return "i'm server-y";
    }
}
