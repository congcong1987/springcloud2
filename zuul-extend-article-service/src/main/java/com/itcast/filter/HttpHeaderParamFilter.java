package com.itcast.filter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itcast.support.RibbonFilterContextHolder;


/**
 * 接收Zuul过来的用户信息
 * @author zhangyong
 *
 */
public class HttpHeaderParamFilter implements Filter{
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//System.out.println("zuul接收过来的参数..........");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		httpResponse.setCharacterEncoding("UTF-8");
		httpResponse.setContentType("application/json; charset=utf-8");
		String uid = httpRequest.getHeader("uid");
		RibbonFilterContextHolder.getCurrentContext().add("uid", uid);
		chain.doFilter(httpRequest, response);
	}

	@Override
	public void destroy() {

	}
}
