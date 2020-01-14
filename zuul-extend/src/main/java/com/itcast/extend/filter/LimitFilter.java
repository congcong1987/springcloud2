package com.itcast.extend.filter;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;

import com.google.common.util.concurrent.RateLimiter;
import com.itcast.auth.common.ResponseCode;
import com.itcast.auth.common.ResponseData;
import com.itcast.auth.util.JsonUtils;
import com.itcast.extend.config.BasicConf;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
public class LimitFilter extends ZuulFilter {
	 private Logger log = LoggerFactory.getLogger(LimitFilter.class);
	 public static volatile RateLimiter rateLimiter = RateLimiter.create(100);
	 	@Autowired
	    @Qualifier("longRedisTemplate")
	    private RedisTemplate<String, Long> redisTemplate;

	    @Autowired
	    private BasicConf basicConf;
	    
	    public LimitFilter() {
	        super();
	    }

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
	        return 0;
	    }
	    
	    @Override
	    public Object run() {
	        RequestContext ctx = RequestContext.getCurrentContext();
	        Long currentSecond = System.currentTimeMillis() / 1000;
	        String key = "zhangyong-api-rate-limit-" + currentSecond;
	        
	        log.info(key+"===>进行限流***********");
	        try {
	            if (!redisTemplate.hasKey(key)) {
	                redisTemplate.opsForValue().set(key, 0L, 100, TimeUnit.SECONDS);
	            }

	            // 当集群中当前秒的并发量达到了设定的值，不进行处理，注意集群中的网关所在服务器时间必须同步
//	            if (redisTemplate.opsForValue().increment(key, 1) > basicConf.getClusterLimitRate()) {
	             if (redisTemplate.opsForValue().increment(key, 1) > 100) {
	                ctx.setSendZuulResponse(false);
	                ctx.set("isSuccess", false);
	                ResponseData data = ResponseData.fail("当前负载太高，请稍后重试", ResponseCode.LIMIT_ERROR_CODE.getCode());
	                ctx.setResponseBody(JsonUtils.toJson(data));
	                ctx.getResponse().setContentType("application/json; charset=utf-8");
	                return null;
	            }
	        } catch (Exception e) {
	           log.error("集群限流异常", e);
	            // Redis挂掉等异常处理，可以继续单节点限流
	            // 单节点限流
	            rateLimiter.acquire();
	            log.info("单点限流.....");
	        }

	        return null;
	    }
}
