package com.lhb.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhb.dao.RoleMapper;
import com.lhb.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	public List<Map> selectRolesByUserId(String loginName) {
		return roleMapper.selectRolesByUserId(loginName);
	}

}
