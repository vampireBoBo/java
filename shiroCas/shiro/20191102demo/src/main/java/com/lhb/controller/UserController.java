package com.lhb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.lhb.entity.User;
import com.lhb.service.UserService;

import lombok.extern.slf4j.Slf4j;
/**
 * 用户类 视图层
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {
	
	@Autowired
	private UserService userService;
	/**
	 * 获取列表
	 * @return
	 */
	@SuppressWarnings("finally")
	@RequestMapping(value="/list",method=RequestMethod.GET)
	@ResponseBody
	public String getList(){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			List<User> list = userService.selectListByParams();
			result.put("status", 1);
			result.put("data",JSON.toJSONString(list));
		} catch (Exception e) {
			result.put("status", -1);
			log.error("用户列表获取失败："+e.getMessage());
			e.printStackTrace();
		}finally{
			return JSON.toJSONString(result);
		}
	}
}
