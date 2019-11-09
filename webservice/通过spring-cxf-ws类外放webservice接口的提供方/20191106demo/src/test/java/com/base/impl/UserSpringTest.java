package com.base.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.base.SpringTestBase;
import com.lhb.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/application.xml"})
public class UserSpringTest{
	
	@Autowired
	private UserService userService;
	
	@Test
	public void testDemo(){
		JSONObject json = new JSONObject();
		json.put("name", "张三");
		json.put("age", 13);
		json.put("gender", "男性");
		String result = userService.getUser(json.toJSONString());
		System.out.println("=接口调用结果=="+result);
	}
	
}
