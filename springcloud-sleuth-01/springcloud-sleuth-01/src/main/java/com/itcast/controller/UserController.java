package com.itcast.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.itcast.service.ArticleService;
import com.itcast.service.UserService;

import brave.Tracer;

@RestController
public class UserController {
private Logger logger = LoggerFactory.getLogger(UserController.class);


	@Autowired
   UserService userService;
	@Autowired
	ArticleService articleService;
	
	
	@Autowired 
	Tracer tracer;
	
	/*@Autowired 	
	private RestTemplate restTemplate;  */	
	
	
	@GetMapping("/user/hello")
	public String hello() {
		logger.info("我是/user/hello");
		
		userService.sayUser();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "hello";
	}
	
	
	
	@GetMapping("/async")
	public String helloSleuthAsync() throws InterruptedException {
	    logger.info("Before Async Method Call");
	    articleService.saveLog("test  ..async");
	    logger.info("After Async Method Call");
	    return "success";
	}
	
	@GetMapping("/user/hello2") 	
	public String callHello() { 		
		logger.info("我是/article/callHello");
		tracer.currentSpan().tag("用户", "yinjihuan");
		articleService.saveLog("test");
		articleService.saveLog2("test");
		return "hahah---ok";
	   /* return restTemplate.getForObject(
			"http://sleuth-user-service/user/hello", String.class); 	*/
	}
}
