package com.itcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 微服务之间直接调用的认证中心
 * @author yinjihuan
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AuthInfoApplication {
	public static void main(String[] args) {
		System.out.println("微服务之间直接调用的认证中心......");
	    SpringApplication.run(AuthInfoApplication.class, args);
	}
}
