package com.itcast.extend.filter;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.itcast.auth.common.ResponseCode;
import com.itcast.auth.common.ResponseData;
import com.itcast.auth.util.JsonUtils;
import com.itcast.extend.config.BasicConf;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;


/**
 * 服务降级过滤器
 *
 * @author zhangyong
 **/
public class DownGradeFilter extends ZuulFilter{
	
	 @Autowired
	    private BasicConf basicConf;
	
	public DownGradeFilter() {
        super();
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        Object success = ctx.get("isSuccess");
        return success == null ? true : Boolean.parseBoolean(success.toString());
    }

    @Override
    public String filterType() {
        return "route";
    }

    @Override
    public int filterOrder() {
        return 4;
    }

    @Override
    public Object run() {
    	System.out.println("服务降级**********");
        RequestContext ctx = RequestContext.getCurrentContext();
        Object serviceId = ctx.get("serviceId");
        if (serviceId != null && basicConf != null) {
        	String arr[]={"zuul-extend-article-service"};
           // List<String> serviceIds = Arrays.asList(basicConf.getDownGradeServiceStr().split(","));
            List<String> serviceIds = Arrays.asList(arr);
            if (serviceIds.contains(serviceId.toString())) {
                ctx.setSendZuulResponse(false);
                ctx.set("isSuccess", false);
                ResponseData data = ResponseData.fail("服务降级中", ResponseCode.DOWNGRADE.getCode());
                ctx.setResponseBody(JsonUtils.toJson(data));
                ctx.getResponse().setContentType("application/json; charset=utf-8");
                return null;
            }
        }
        return null;
    }
}
