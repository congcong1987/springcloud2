package com.itcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpingCloudAdminClientApplication {
	
	 public static void main(String[] args) {
		 System.out.println("spingcloud client===>port=7203");
	        SpringApplication.run( SpingCloudAdminClientApplication.class, args );
	    }

}
