package com.itcast.auth.service;

import org.springframework.stereotype.Service;

import com.itcast.auth.po.User;
import com.itcast.auth.query.AuthQuery;



@Service
public class AuthServiceImpl implements AuthService {

	@Override
	public User auth(AuthQuery query) {
		return new User(1L);
	}

}
