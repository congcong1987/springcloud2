package com.itcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class SpringCloudSwaggerZuul {
	public static void main(String[] args) {
		
		System.out.println("启动...zuul.....网关   8091");
		SpringApplication.run(SpringCloudSwaggerZuul.class, args);
	}
}
