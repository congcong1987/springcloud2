package com.itcast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itcast.config.StudentConfig;

@RestController
@RequestMapping("/test")
public class TestController {
	 @Value("${myName}")
	    private String myName;
	 
	 
	 @Autowired
	    private StudentConfig studentConfig;
	 
	 
	
	 
	    @RequestMapping("/myname")
	    public String testHello(){
	        System.out.println("my name is : "+myName);
	        return myName;
	    }
	 
	    @RequestMapping("/config")
	    public String testConfig(){
	        System.out.println(studentConfig.toString());
	        return studentConfig.toString();
	    }

	
}
