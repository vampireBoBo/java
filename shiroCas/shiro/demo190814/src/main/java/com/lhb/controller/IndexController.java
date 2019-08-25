package com.lhb.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("")
public class IndexController {
	private final Logger log = LogManager.getLogger();
	
	/**
	 * 登录
	 * @return  返回结果值
	 */
	@GetMapping(value="/index")
	public String login(HttpServletResponse rep){
		log.error("==跳转首页==");
		try {
			rep.setContentType("text/html;charset=UTF-8");
			String path=System.getProperty("catalina.home");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
}
