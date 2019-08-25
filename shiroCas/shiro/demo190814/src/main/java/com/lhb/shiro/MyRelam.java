package com.lhb.shiro;

import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

public class MyRelam extends AuthorizingRealm{

	/*public static void main(String[] args) {
		SimpleHash result = new SimpleHash("MD5", "lhb", "lhb", 1024);
		System.out.println("==密码=="+result.toString());
	}*/
	
	private Logger log = LogManager.getLogger();
	
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		String username = principal.toString();
		
		// lhb === 封装普通用户角色 user
		if(username.equalsIgnoreCase("lhb")){
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(); 
			Set<String> roles = new HashSet<String>();
			roles.add("user");
			info.setRoles(roles);
			return info;
		}
		
		// admin === 封装超级用户角色 admin
		if(username.indexOf("admin")>=0){
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(); 
			Set<String> roles = new HashSet<String>();
			roles.add("admin");
			roles.add("user");
			info.setRoles(roles);
			
			
			//  给 admin1  和  admin2  设置不同的操作权限  
			// admin1:具有增删改查
			if(username.indexOf("admin1")>=0){
				Set<String> stringPermissions = new HashSet<String>();
				stringPermissions.add("user:all");
				info.setStringPermissions(stringPermissions);
			}
			
			// admin2:具有修改权限
			if(username.indexOf("admin2")>=0){
				Set<String> stringPermissions = new HashSet<String>();
				stringPermissions.add("user:update");
				info.setStringPermissions(stringPermissions);
			}
			
			return info;
		}
		return null;
	}

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		log.error("【===myRealm===】");
		
		String principal = (String) token.getPrincipal();
		if(principal .equalsIgnoreCase("lhb") || principal.indexOf("admin")>=0){
			String credentials = principal;  // 数据库查询密码
			if(principal .equalsIgnoreCase("lhb") ){
				credentials = "017ed7f567524e080c9986b7663d1a8c";
			}
			if(principal.indexOf("admin")>=0 ){
				credentials = "ca49143de349dcc0f276e090cc55770b";
			}
			ByteSource soalt = ByteSource.Util.bytes("lhb");
			return new SimpleAuthenticationInfo(principal,credentials,soalt,getName());
		}else{
			throw new UnknownAccountException("用户不存在...");
		}
	}

}
