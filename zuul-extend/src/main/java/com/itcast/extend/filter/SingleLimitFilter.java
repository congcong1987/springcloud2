package com.itcast.extend.filter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

//局部限流
public class SingleLimitFilter extends ZuulFilter{
	private Logger log = LoggerFactory.getLogger(SingleLimitFilter.class);
	 public static volatile RateLimiter rateLimiter = RateLimiter.create(100);
	
	@Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }
    
    @Override
    public Object run() {
    	log.info("局部限流********");
    	rateLimiter.acquire();
        return null;
    }
}
