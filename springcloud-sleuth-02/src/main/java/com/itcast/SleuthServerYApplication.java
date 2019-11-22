package com.itcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;

@EnableDiscoveryClient
@SpringBootApplication
public class SleuthServerYApplication {
	
	
	@Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
	
	@Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
	
	public static void main(String[] args) {
		
		
		System.out.println("服务追踪。。。。。。。。。。。。。。。。。8093.......");
		SpringApplication.run(SleuthServerYApplication.class, args);
	}
}
