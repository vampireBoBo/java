package com.lhb.service.impl;

import org.springframework.stereotype.Service;

import com.lhb.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	public void getStudent() {
		System.out.println("这是一个service");
	}

}
