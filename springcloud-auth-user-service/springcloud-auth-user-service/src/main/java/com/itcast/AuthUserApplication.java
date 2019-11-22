package com.itcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * Eureka客户端示列
 * 
 * @author cong
 * 
 * @about http://cxytiandi.com/about
 * 
 * @date 2018-12-22
 * 
 */
@EnableDiscoveryClient
@SpringBootApplication
public class AuthUserApplication {
	public static void main(String[] args) {
		System.out.println("提供者。。。。。。。。。。。");
		SpringApplication.run(AuthUserApplication.class, args);
	}
}
