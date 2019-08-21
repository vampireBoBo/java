package com.lhb.logweb01.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.PropertyConfigurator;

/**
 * Servlet implementation class Log4jServlet
 * 
 * log4j配置文件初始化加载  servlet
 */
@WebServlet("/log4jServlet")
public class Log4jServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	public void init(ServletConfig config) throws ServletException {
		// 初始化方法
		super.init(config);
		initConfig(config);
	}

	// 初始化参数
	public void initConfig(ServletConfig config){
		String path1 = getServletContext().getRealPath("/");   // 获取当前项目部署的绝对路径  并包含项目路径
		String path2 = getServletContext().getContextPath();   // 获取当前项目的名称
		System.out.println(path1+"====获取对应的路径==="+path2);
		// 获取log4j上下文变量
		String path = (String) getServletContext().getInitParameter("log4jConfigLocation");
		System.out.println("log4j的配置文件路径"+path);
		PropertyConfigurator.configure(path1+path);  // 需要配置文件的绝对路径  此处为：D:\Tomcat 7.0\webapps\logwebdemo-01\WEB-INF\classes\properties\log4j.properties
	}
}
