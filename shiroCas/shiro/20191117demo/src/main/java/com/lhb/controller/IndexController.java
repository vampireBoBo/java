package com.lhb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lhb.service.IUserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("index")
@Slf4j
public class IndexController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/test")
	@ResponseBody
	public void testIndex() {
		log.error("这是一个controller  使用日志打印功能");
		userService.getStudent();
	}
}
