package com.lhb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.lhb.entity.User;
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
		List<User> list = userService.selectList();
		log.error("用户信息==="+JSON.toJSONString(list));
		log.error("进入user的controller层");
		return "/user/list";
	}
}
