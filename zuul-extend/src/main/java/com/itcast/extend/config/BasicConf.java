package com.itcast.extend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
public class BasicConf {
	
	// API接口白名单，多个用逗号分隔
	@Value("${apiWhiteStr:/zuul-extend-user-service/user/login}")
	private String apiWhiteStr;

	@Value("${limitRate:10}")
	private double limitRate;
	
	@Value("${api.clusterLimitRate:100}")
	private int clusterLimitRate;
	 
	@Value("${downGradeServiceStr:default}")
	private String downGradeServiceStr;

	@Value("${grayPushServers:default}")
	private String grayPushServers;

	@Value("${grayPushUsers:default}")
	private String grayPushUsers;
	
	
	
}
