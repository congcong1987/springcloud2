package com.itcast;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@ImportResource(locations = { "classpath:applicationContext.xml" })
public class JobApplication {
	
	public static void main(String[] args) {
		System.out.println("elastic  job start ***************");
		SpringApplication.run(JobApplication.class, args);
	}

}
