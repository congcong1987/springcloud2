package com.itcast.auth.service;

import com.itcast.auth.po.User;
import com.itcast.auth.query.AuthQuery;

public interface AuthService {

	User auth(AuthQuery query);
	
}
