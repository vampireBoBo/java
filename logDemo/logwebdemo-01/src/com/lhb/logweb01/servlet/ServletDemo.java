package com.lhb.logweb01.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 前端url请求的处理类
 * 
 * 当前servlet添加@WebServlet ，若同时在web.xml配置该servlet的url路径时 若两条路径不相同  则都可生效，若相同 则会抛出异常，然后去掉其中一个即可 
 */
@WebServlet("/ServletDemo")
public class ServletDemo extends HttpServlet {
	
	// case1：slf4j +  log4j  获取日志实例  配置文件为：默认路径默认名称，即存放再src根目录下的log4j.properties配置文件夹
	private Logger log = LoggerFactory.getLogger(ServletDemo.class);
	
	private static final long serialVersionUID = 1L;
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	System.out.println("===indexServlet执行初始化==");
    }   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("====我是case1==  配置文件使用默认路径和位置");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
