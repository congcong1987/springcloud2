package com.itcast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

@EnableAsync
@EnableDiscoveryClient
@SpringBootApplication
public class SleuthDemoApplication {
	
	
	@Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
	
	public static void main(String[] args) {
		
		

List<String> list = new ArrayList<>();
list.add("aaa bbb ccc");
list.add("ddd eee fff");
list.add("ggg hhh iii");
 
list = list.stream().map(s -> s.split(" ")).flatMap(Arrays::stream).collect(Collectors.toList());
//list.forEach(System.out::println);
list.forEach(s->System.out.println(s));
		
		System.out.println("服务追踪。。。。。。。。。。。。。。。。。8092.......");
		SpringApplication.run(SleuthDemoApplication.class, args);
	}
}
