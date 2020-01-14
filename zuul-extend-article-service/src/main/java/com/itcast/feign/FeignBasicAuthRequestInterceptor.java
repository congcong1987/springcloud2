package com.itcast.feign;


import java.util.Map;

import com.itcast.support.RibbonFilterContextHolder;

import feign.RequestInterceptor;
import feign.RequestTemplate;
/**
 * 传递用户信息到被调用的服务
 * 
 * feign拦截器
 * 
 * @author zy
 *
 */
public class FeignBasicAuthRequestInterceptor implements RequestInterceptor{
	public FeignBasicAuthRequestInterceptor() {

	}

	@Override
	public void apply(RequestTemplate template) {
		//System.out.println("feign 拦截器!**********");
		Map<String, String> attributes = RibbonFilterContextHolder.getCurrentContext().getAttributes();
		for (String key : attributes.keySet()) {
			String value = attributes.get(key);
			template.header(key, value);
		}
	}
}
