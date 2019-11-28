package com.itcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.itcast.config.StudentConfig;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableConfigurationProperties({StudentConfig.class})
public class ConsulConfigApplication {
	public static void main(String[] args) {
		System.out.println("配置中心..........");
		SpringApplication.run(ConsulConfigApplication.class, args);
	}
}
