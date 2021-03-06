package com.itcast.extend.filter;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.itcast.auth.common.ResponseCode;
import com.itcast.auth.common.ResponseData;
import com.itcast.auth.util.JWTUtils;
import com.itcast.auth.util.JsonUtils;
import com.itcast.extend.config.BasicConf;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 认证过滤器   --过滤认证
 *
 * @author zhangyong
 * 
 **/
public class AuthFilter extends ZuulFilter {

    @Autowired
    private BasicConf basicConf;

    public AuthFilter() {
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
        return 1;
    }

    @Override
    public Object run() {
    	System.out.println("进行网关拦截..........");
        RequestContext ctx = RequestContext.getCurrentContext();
        String token = ctx.getRequest().getHeader("Authorization");
        JWTUtils jwtUtils = JWTUtils.getInstance();
        String apis = "/zuul-extend-user-service/user/login,/zuul-extend-user-service/user/test,/zuul-extend-article-service/article/test";
        //白名单，放过
        List<String> whileApis = Arrays.asList(apis.split(","));
        String uri = ctx.getRequest().getRequestURI();
        String ipaddr = ctx.getRequest().getRemoteAddr();
        System.out.println(ipaddr+"==============>访问地址:"+getIpAddr(ctx.getRequest()));
        if (whileApis.contains(uri)) {
            return null;
        }
        // path uri 处理
        for (String wapi : whileApis) {
            if (wapi.contains("{") && wapi.contains("}")) {
                if (wapi.split("/").length == uri.split("/").length) {
                    String reg = wapi.replaceAll("\\{.*}", ".*{1,}");
                    System.err.println(reg);
                    Pattern r = Pattern.compile(reg);
                    Matcher m = r.matcher(uri);
                    if (m.find()) {
                        return null;
                    }
                }
            }
        }

        //验证TOKEN
        if (!StringUtils.hasText(token)) {
            ctx.setSendZuulResponse(false);
            ctx.set("isSuccess", false);
            ResponseData data = ResponseData.fail("非法请求【缺少Authorization信息】", ResponseCode.NO_AUTH_CODE.getCode());
            ctx.setResponseBody(JsonUtils.toJson(data));
            ctx.getResponse().setContentType("application/json; charset=utf-8");
            return null;
        }

        JWTUtils.JWTResult jwt = jwtUtils.checkToken(token);
        if (!jwt.isStatus()) {
            ctx.setSendZuulResponse(false);
            ctx.set("isSuccess", false);
            ResponseData data = ResponseData.fail(jwt.getMsg(), jwt.getCode());
            ctx.setResponseBody(JsonUtils.toJson(data));
            ctx.getResponse().setContentType("application/json; charset=utf-8");
            return null;
        }
        System.err.println("用戶ID"+jwt.getUid());
        ctx.addZuulRequestHeader("uid", jwt.getUid());
        return null;
    }
    
    
    		public  String getIpAddr(HttpServletRequest request)  {
    	         String ip  =  request.getHeader( " x-forwarded-for " );
    	           if (ip  ==   null   ||  ip.length()  ==   0   ||   " unknown " .equalsIgnoreCase(ip))  {
    	              ip  =  request.getHeader( " Proxy-Client-IP " );
    	          } 
    	            if (ip  ==   null   ||  ip.length()  ==   0   ||   " unknown " .equalsIgnoreCase(ip))  {
    	              ip  =  request.getHeader( " WL-Proxy-Client-IP " );
    	          } 
    	           if (ip  ==   null   ||  ip.length()  ==   0   ||   " unknown " .equalsIgnoreCase(ip))  {
    	             ip  =  request.getRemoteAddr();
    	          } 
    	           return  ip;
    	     }

}
