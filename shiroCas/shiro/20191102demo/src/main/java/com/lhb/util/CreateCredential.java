package com.lhb.util;

import org.apache.shiro.crypto.hash.SimpleHash;

public class CreateCredential {
	public static void main(String[] args) {
		String loginName = "lhb";  // 登录名称
 		String algorithmName = "Md5";  // 算法名称
		String source = "12345";  // 原始密码
		String salt = loginName.toUpperCase();  // 加密盐值 === 登录名称的全大写
		int iterations = 1024;
		// 手动获取加密后的密码
		Object credential = new SimpleHash(algorithmName, source, salt, iterations);
		System.out.println(source+"===加密结果为=="+credential);
	}
}
