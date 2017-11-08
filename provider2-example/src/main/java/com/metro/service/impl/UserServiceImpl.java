package com.metro.service.impl;

import org.springframework.stereotype.Component;

import com.metro.response.dto.Data;
import com.metro.service.UserService;

/**
 * Service to mock the user details information required for the services.
 *
 */
@Component
public class UserServiceImpl implements UserService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metro.service.UserService#getUserDetails()
	 */
	public Data getDataDetails() {
		Data data = new Data();
		data.setUserName("michel");
		data.setPassword("michel");
		return data;
	}

}
