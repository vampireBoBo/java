package com.lhb.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.lhb.service.IndexService;

import lombok.extern.slf4j.Slf4j;


@Controller
@RequestMapping("/index")
@Slf4j
public class IndexController {
	
	@RequestMapping(value="/login",produces="application/json;charset=UTF-8")
	public ModelAndView login(@RequestParam String username ,@RequestParam String password,HttpServletResponse rep){
		ModelAndView model = new ModelAndView("home");
		JSONObject result = new JSONObject();
		result.put("statue", -1);
		try {
			log.error("登录用户请求参数为："+username+"==="+password);
			UsernamePasswordToken tocken = new UsernamePasswordToken(username, password);
			SecurityUtils.getSubject().login(tocken);
			log.error("执行完毕");
			result.put("statue",1);
			result.put("message","用户登录成功");
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			result.put("message",e.getMessage() );
		}
		return model;
	}
	
}
