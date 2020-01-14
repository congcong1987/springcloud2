package com.itcast.extend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.itcast.extend.filter.AuthFilter;
import com.itcast.extend.filter.DownGradeFilter;
import com.itcast.extend.filter.SingleLimitFilter;

@Configuration
public class FilterConfig {
	
	@Bean
	public AuthFilter authFilter() {
		return new AuthFilter();
	}
	
		@Bean
		public SingleLimitFilter singleLimitFilter() {
			return new SingleLimitFilter();
		}
	
	
	//全局限流
	/*@Bean
	public LimitFilter limitFilter() {
		return new LimitFilter();
	}*/
		
		
		@Bean
		public DownGradeFilter downGradeFilter() {
			return new DownGradeFilter();
		}
	
	
}
