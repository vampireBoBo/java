package com.lhb.controller;

import javax.servlet.http.HttpServletResponse;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.lhb.entity.User;

@Controller
@RequestMapping("")
public class LoginController {
	private final Logger log = LogManager.getLogger();
	/**
	 * 登录
	 * @return  返回结果值
	 */
	@ResponseBody
	@GetMapping(value="/login")
	public String login(HttpServletResponse rep,User user){
		log.error("开始执行登录方法,请求参数为："+JSON.toJSONString(user));
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
		SecurityUtils.getSubject().login(token);
		log.error("用户登录成功");
		return null;
	}
}
