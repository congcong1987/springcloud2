package cong.cong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Spingcloud2EurekaServer {
	
	 public static void main(String[] args) {
		 System.out.println("注册中心*******8800");
	        SpringApplication.run(Spingcloud2EurekaServer.class, args);
	    }
}
