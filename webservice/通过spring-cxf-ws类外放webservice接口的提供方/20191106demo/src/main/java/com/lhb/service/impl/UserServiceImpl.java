package com.lhb.service.impl;


import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lhb.service.UserService;

@Component("userService")
public class UserServiceImpl implements UserService {

	public String getUser(String params) {
		JSONObject result = new JSONObject();
		result.put("status", "success");
		try {
			JSONObject json = JSONObject.parseObject(params);
			System.out.println(params+"请求参数==="+JSON.toJSONString(json));
		} catch (Exception e) {
			result.put("status", "failuer");
			e.printStackTrace();
		}
		return result.toJSONString();
	}

	public String getOne(String name,int age) {
		return "您好 "+name;
	}

}
