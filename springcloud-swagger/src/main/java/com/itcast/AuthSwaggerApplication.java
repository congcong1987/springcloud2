package com.itcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.spring4all.swagger.EnableSwagger2Doc;

	@EnableDiscoveryClient
	@EnableSwagger2Doc
	@SpringBootApplication
	public class AuthSwaggerApplication {
	
		
		public static void main(String[] args) {
			System.out.println("swagger........begin..........start.........");
		    SpringApplication.run(AuthSwaggerApplication.class, args);
		}
	}
