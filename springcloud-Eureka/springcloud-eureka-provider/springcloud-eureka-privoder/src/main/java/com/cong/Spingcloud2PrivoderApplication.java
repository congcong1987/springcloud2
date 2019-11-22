package com.cong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * 相同点：@EnableDiscoveryClient和@EnableEurekaClient都是能够让注册中心能够发现，扫描到改服务。
不同点：@EnableEurekaClient只适用于Eureka作为注册中心，@EnableDiscoveryClient 可以是其他注册中心。
————————————————
版权声明：本文为CSDN博主「程裕强」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/chengyuqiang/article/details/90645498
 * @author DELL
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Spingcloud2PrivoderApplication {

	
	public static void main(String[] args) {
		System.out.println("提供者**************");
		SpringApplication.run(Spingcloud2PrivoderApplication.class, args);
	}
}
