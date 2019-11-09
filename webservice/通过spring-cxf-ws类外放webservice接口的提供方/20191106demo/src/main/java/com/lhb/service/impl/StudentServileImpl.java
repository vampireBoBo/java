package com.lhb.service.impl;

import com.lhb.service.StudentService;

public class StudentServileImpl implements StudentService {

	public String getStudent(String params) {
		return "=请求参数为=="+params;
	}

	public String getOne() {
		return "你好  接口调用成功";
	}

}
