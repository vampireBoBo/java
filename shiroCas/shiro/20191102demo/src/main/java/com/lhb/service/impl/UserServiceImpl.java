package com.lhb.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.lhb.dao.UserMapper;
import com.lhb.entity.User;
import com.lhb.service.UserService;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class UserServiceImpl implements UserService{

	@Autowired
	private  UserMapper userMapper;
	
	public int deleteByPrimaryKey(Integer uid) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insert(com.lhb.entity.User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertSelective(com.lhb.entity.User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public com.lhb.entity.User selectByPrimaryKey(Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateByPrimaryKeySelective(com.lhb.entity.User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByPrimaryKey(com.lhb.entity.User record) {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * 根据条件  查询的列表
	 */
	public List<User> selectListByParams (){
		log.error("userService 读取用户列表");
		List<User> list = userMapper.selectListByParams();
		log.error("用户查询结果："+JSON.toJSONString(list));
		return list;
	}

	/**
	 * 根据用户登录名称获取用户信息
	 */
	public User selectByLoginName(String loginName) {
		return userMapper.selectByLoginName(loginName);
	}
}
