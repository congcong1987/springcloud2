package com.itcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class ZuulExtendApplication {

	public static void main(String[] args) {
		
		System.out.println("网关服务启动**********");
		SpringApplication.run(ZuulExtendApplication.class, args);
	}
}
