package com.itcast.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itcast.apilimit.ApiRateLimit;
import com.itcast.feign.UserRemoteClient;

@RestController
public class ArticleController {
	private static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	@Autowired
	private UserRemoteClient userRemoteClient;
	
	@Autowired
	private HttpServletRequest request;
	
	@ApiRateLimit(confKey = "open.api.callHello")
	@GetMapping("/article/callHello") 	
	public String callHello() {
		System.err.println("用户ID:" + request.getHeader("uid"));
	    return userRemoteClient.hello()+"===port="+ request.getServerPort(); 
	}
	
	
	@ApiRateLimit(confKey = "open.api.test")
	@GetMapping("/article/test") 	
	public String testHello() {
		System.out.println("service ArticleController, port: " + request.getServerPort() );
		System.out.println(Thread.currentThread().getName()+"==>处理"+sf.format(new Date()));
	    return userRemoteClient.test()+"===port="+ request.getServerPort(); 	
	}
}
