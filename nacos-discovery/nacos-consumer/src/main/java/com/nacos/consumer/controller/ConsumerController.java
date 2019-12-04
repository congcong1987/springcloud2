package com.nacos.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nacos.consumer.client.ProviderClient;

@RestController
public class ConsumerController {
	 @Autowired
	    RestTemplate restTemplate;

	    @Autowired
	    ProviderClient providerClient;

	    @GetMapping("/hi-resttemplate")
	    public String hiResttemplate(){
	        return restTemplate.getForObject("http://nacos-provider/hi?name=resttemplate",String.class);

	    }

	    @GetMapping("/hi-feign")
	    public String hiFeign(){
	       return providerClient.hi("feign");
	    }
}
