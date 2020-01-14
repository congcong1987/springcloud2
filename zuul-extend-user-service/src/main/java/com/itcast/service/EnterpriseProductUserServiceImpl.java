package com.itcast.service;

import org.springframework.stereotype.Service;

import com.itcast.auth.util.JWTUtils;



@Service
public class EnterpriseProductUserServiceImpl implements EnterpriseProductUserService {

    @Override
    public String login(Long eid, String uid) {
        JWTUtils jwtUtils = JWTUtils.getInstance();
        if (eid.equals(1L) && uid.equals("1001")) {
        	
        	String token = jwtUtils.getToken(uid);
        	System.out.println("获取token 。。。。="+token);
            return token;
        }
        return null;
    }
    
}
