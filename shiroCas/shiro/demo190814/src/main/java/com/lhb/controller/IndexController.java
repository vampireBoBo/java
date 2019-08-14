package com.lhb.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("")
public class IndexController {
	/**
	 * 登录
	 * @return  返回结果值
	 */
	@ResponseBody
	@GetMapping(value="/login")
	public String login(HttpServletResponse rep){
		String result = "使用springmvc中的类设置编码方式";
		try {
			/*rep.setCharacterEncoding("UTF-8");*/
			rep.setContentType("text/html;charset=UTF-8");
			/*PrintWriter w = rep.getWriter();
			w.write("使用流的方式进行返回");
			w.flush();
			w.close();*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
