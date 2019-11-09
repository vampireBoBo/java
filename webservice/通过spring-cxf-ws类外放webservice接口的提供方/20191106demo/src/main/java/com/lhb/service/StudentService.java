package com.lhb.service;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
/**
 * 发布一个 restful风格的  webservice接口  其将不再使用wsdl进行访问
 * @author Administrator
 *
 */
@WebService
@Path("/student")
public interface StudentService {
	@POST
	@Path("/getStudent")
	@Consumes({"application/json;charset=UTF-8"})  //指定请求的数据类型及编码格式
	@Produces({"application/json;charset=UTF-8" })  //指定返回的数据类型及编码格式
	public String getStudent(String params);
	@GET
	@Path("/getOne")
	@Produces({ "application/json;charset=UTF-8" })//指定返回的数据类型
	public String getOne();
}
