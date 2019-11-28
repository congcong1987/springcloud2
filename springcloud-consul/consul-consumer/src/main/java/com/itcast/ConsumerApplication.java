package com.itcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerApplication {
	public static void main(String[] args) {
		System.out.println("消费者。。。。。。。。begin..........");
		SpringApplication.run(ConsumerApplication.class, args);
	}

}
