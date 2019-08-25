package com.lhb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lhb.entity.User;
/**
 * 用户管理视图层  【增、删、改==需要admin权限    查询==皆可】
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	private final Logger log = LogManager.getLogger();
	/**
	 * 登录
	 * @return  返回结果值
	 */
	@RequiresRoles(value={"admin"})
	@GetMapping(value="/manageList")
	public String login(HttpServletRequest req){
		List<User> list = new ArrayList<User>();
		for(int i=1;i<6;i++){
			User user = new User();
			user.setUsername("lhb");
			user.setName("罗云熙");
			user.setPassword("lhb");
			user.setAge(18);
			user.setGender("女");
			user.setPhone("13517676876");
			list.add(user);
		}
		req.setAttribute("list",list);
		return "/user/manage";
	}
}
