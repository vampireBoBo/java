package com.lhb.realm;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.coyote.http2.ByteUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.lhb.entity.User;
import com.lhb.service.RoleService;
import com.lhb.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * 自定义shiro  数据源
 * @author Administrator
 *
 */
@Slf4j
public class MyRealm extends AuthorizingRealm{
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pricipal) {
		String loginName = (String) pricipal.getPrimaryPrincipal();
		log.error("开始获取角色的信息");
		List<Map> roleMap = roleService.selectRolesByUserId(loginName);
		Set<String> roles = new HashSet<String>();
		if(roleMap!=null && roleMap.size()>0){
			for(Map map : roleMap){
				roles.add((String)map.get("rcode"));
			}
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setRoles(roles);
		
		log.error("开始获取权限的信息");
		return info;
	}

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken tocken) throws AuthenticationException {
		String principal = (String) tocken.getPrincipal();
		log.error("进入认证接口内部====");
		User user = userService.selectByLoginName(principal);
		if(user==null){
			throw new UnknownAccountException("当前用户不存在");
		}
		//return new SimpleAuthenticationInfo(principal, user.getLoginpassword(),getName());
		
		
		// 使用盐值加密
		ByteSource salt = ByteSource.Util.bytes("LHB");
		return new SimpleAuthenticationInfo(principal, user.getLoginpassword(),salt, getName());
	}
	
	// 根据加密钱用户登录名和密码  得到加密后的值
	public static void main(String[] args) {
		String tr = "123456";
		Object tokenHashedCredentials = new SimpleHash("Md5", "123456", "LYX", 1024);
		System.out.println("==="+tokenHashedCredentials);
	}
}
