package com.lhb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhb.dao.UserMapper;
import com.lhb.entity.User;
import com.lhb.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service("userService")
@Slf4j
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	public void testSpring(){
		log.error("测试spring框架的依赖注入是否成功");
	}

	public int deleteByPrimaryKey(Integer uid) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insert(User record) {
		User user = new User();
		user.setUid(6);
		user.setUname("测试");
		userMapper.insert(user);
		log.error("用户新增成功");
		return 0;
	}

	public int insertSelective(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public User selectByPrimaryKey(Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateByPrimaryKeySelective(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByPrimaryKey(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<User> selectList() {
		return userMapper.selectList();
	}
}
