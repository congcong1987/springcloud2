package com.itcast.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * Feign请求拦截器
 * 
 * @author yinjihuan
 *
 **/
public class FeignBasicAuthRequestInterceptor implements RequestInterceptor {
	public FeignBasicAuthRequestInterceptor() {
		
	}

	@Override
	public void apply(RequestTemplate template) {
		System.out.println("设置头部信息..........");
		template.header("Authorization", System.getProperty("fangjia.auth.token"));
	}
}