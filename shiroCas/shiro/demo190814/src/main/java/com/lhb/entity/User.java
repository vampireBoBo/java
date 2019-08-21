package com.lhb.entity;

import java.io.Serializable;
/**
 * 用户实体
 * @author Administrator
 *
 */
public class User implements Serializable{
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
