<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 超链默认访问的是doGet方法 -->
	<a href="<%=request.getContextPath()%>/index1">点击我调用访问web路径</a> <!-- 访问web.xml中配置的路径 -->
	<br>
	<br>
	<a href="<%=request.getContextPath()%>/ServletDemo">点击我访问webservlet注解路径</a> <!-- 访问使用servlet中@webServlet注解url -->
</body>
</html>