package com.itcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class ZuulUserServiceApp {
	public static void main(String[] args) {
		System.out.println("用户登录信息....http://localhost:2103/zuul-extend-user-service/user/hello");
		SpringApplication.run(ZuulUserServiceApp.class, args);
	}
}
