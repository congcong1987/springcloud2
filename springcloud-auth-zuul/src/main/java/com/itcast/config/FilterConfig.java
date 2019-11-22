package com.itcast.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.itcast.filter.AuthHeaderFilter;

@Configuration
public class FilterConfig {

	@Bean
	public AuthHeaderFilter authHeaderFilter() {
		return new AuthHeaderFilter();
	}
	
}
