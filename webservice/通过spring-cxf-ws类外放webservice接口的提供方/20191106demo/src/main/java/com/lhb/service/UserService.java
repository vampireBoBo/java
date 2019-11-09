package com.lhb.service;

import javax.jws.WebParam;
import javax.jws.WebService;
/**
 * 发布一个 soap协议wsdl语言格式的 webservice服务  即通过wsdl可查看对应的xml文件
 * @author Administrator
 *
 */
@WebService
public interface UserService {
	public String getUser(String params);
	public String getOne(@WebParam(name="name")String name,@WebParam(name="age")int age);
}
