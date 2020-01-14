package com.itcast;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class AriticleExtendApplication {
	public static void main(String[] args) {
		// 指定环境（开发演示用，不能用于生产环境））
		
		
		System.out.println("aritle service.....");
	//	System.setProperty("open.api.defaultLimit", "100");
		SpringApplication.run(AriticleExtendApplication.class, args);
	}
}
