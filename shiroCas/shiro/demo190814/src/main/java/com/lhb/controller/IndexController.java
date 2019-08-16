package com.lhb.controller;

import java.io.PrintWriter;


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
	@ResponseBody
	@GetMapping(value="/login")
	public String login(HttpServletResponse rep){
		log.error("==controller层的日志信息==");
		log.info("==controller层的日志信息==");
		String result = "使用springmvc中的类设置编码方式";
		try {
			/*rep.setCharacterEncoding("UTF-8");*/
			rep.setContentType("text/html;charset=UTF-8");
			/*PrintWriter w = rep.getWriter();
			w.write("使用流的方式进行返回");
			w.flush();
			w.close();*/
			
			String path=System.getProperty("catalina.home");
			log.error("tomcat的访问路径==controller层的日志信息=="+path);
			log.info("tomcat的访问路径==controller层的日志信息=="+path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
