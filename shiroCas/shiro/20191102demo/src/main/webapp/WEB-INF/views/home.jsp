<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<body>
<h2>欢迎 <shiro:principal></shiro:principal> 进入 1102demo</h2>

<shiro:hasRole name="systemAdmin">
	<a href="<%=request.getContextPath()%>/spring/user/list">进入用户管理界面</a>
</shiro:hasRole>
<h3></h3>
</body>
</html>
