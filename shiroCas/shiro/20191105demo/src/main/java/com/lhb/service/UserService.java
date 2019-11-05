package com.lhb.service;

import java.util.List;

import com.lhb.entity.User;

public interface UserService {
	int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> selectList();
}
