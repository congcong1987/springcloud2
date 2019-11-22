package com.itcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
/**
 * Zuul示列
 * 
 * @author cong
 * 
 * @about http://cxytiandi.com/about
 * 
 * @date 2019-11-05
 * 
 */
@EnableFeignClients
@EnableScheduling
@EnableZuulProxy
@SpringBootApplication
public class AuthZuulApplication {
	public static void main(String[] args) {
		SpringApplication.run(AuthZuulApplication.class, args);
	}
}
