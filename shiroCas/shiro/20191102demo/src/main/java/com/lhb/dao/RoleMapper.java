package com.lhb.dao;

import java.util.List;
import java.util.Map;

import com.lhb.entity.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    List<Map> selectRolesByUserId(String loginName);
}