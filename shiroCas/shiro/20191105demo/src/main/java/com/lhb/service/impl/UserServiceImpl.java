package com.lhb.service.impl;

import org.springframework.stereotype.Service;

import com.lhb.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service("userService")
@Slf4j
public class UserServiceImpl implements UserService{
	public void testSpring(){
		log.error("测试spring框架的依赖注入是否成功");
	}
}
