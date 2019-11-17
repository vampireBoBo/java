package com.lhb.service;

import java.util.List;
import java.util.Map;

public interface RoleService {
	 List<Map> selectRolesByUserId(String loginName);
}
