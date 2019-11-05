package com.lhb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lhb.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/list")
	public String list(){
		userService.testSpring();
		
		log.error("进入user的controller层");
		return "/user/list";
	}
}
