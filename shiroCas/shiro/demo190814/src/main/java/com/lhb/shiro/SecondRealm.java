package com.lhb.shiro;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;

import com.lhb.entity.User;

public class SecondRealm extends AuthenticatingRealm {
	
	private  final Logger log = LogManager.getLogger();

	/**
	 * 重写认证方法
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		log.error("【===secondRealm===】");
		
		// 1、获取页面传递的用户登录表单信息
		UsernamePasswordToken tocken = (UsernamePasswordToken) token;
		String principal = tocken.getUsername();
		
		// 2、判断页面传递用户账号是否存在
		if(principal.equalsIgnoreCase("lyx")){
			// 3、将用户的数据库密码 和 对应的加密方式  封装成 simauthenticationInfo 进行返回  由shiro内部完成密码的比对
			String hashedCredentials = "20e677af97778188d24e67dd637270482d3a564f";
			
			// 4、封装加密盐值
			ByteSource credentialsSalt = ByteSource.Util.bytes(principal+1);
			
			// 5、封装用户的基础信息 作为principal
			User user = new User();
			user.setName("罗云熙");
			user.setAge(18);
			user.setGender("男");
			user.setPhone("1351767680");
			user.setUsername("lyx");
			
			return new SimpleAuthenticationInfo(user, hashedCredentials, credentialsSalt, getName());
			
		}else{
			throw new UnknownAccountException("该用户不存在，请核实...");
		}
	}

	
	/*public static void main(String[] args) {
		SimpleHash hash = new SimpleHash("SHA1", "lyx", "lyx"+1, 1024);
		System.out.println("===lyx加密密码为==="+hash.toString());
	}*/
}
