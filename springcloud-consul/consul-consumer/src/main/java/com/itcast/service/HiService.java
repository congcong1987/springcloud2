package com.itcast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itcast.clinet.ConsumerClientFeign;

@Service
public class HiService {
	@Autowired
	ConsumerClientFeign eurekaClientFeign;
 
   
    public String sayHi(String name){
        return  eurekaClientFeign.sayHiFromClientEureka(name);
    }
}
