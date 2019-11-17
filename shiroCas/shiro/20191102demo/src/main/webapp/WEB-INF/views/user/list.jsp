<%-- <%@ page import="com.alibaba.fastjson.JSONObject" %> --%>
<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<body>
<h2>用户管理界面<%-- <%Object result =  request.getAttribute("result");
	JSONObject json = JSONObject.parseObject(JSONObject.toJSONString(result));
	out.println("返回状态==="+json.get("status"));
	
%> --%></h2>

<shiro:hasPermission name="user:all"><a>增加用户</a></shiro:hasPermission> 
<c:if test="${requestScope.result.status gt 0 }" >
	<table>
		<thead>
			<tr>
				<th>学号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.result.data }" var="user" begin="0" >
				<tr>
					<td>${user.uid }</td>
					<td>${user.uname }</td>
					<td>${user.gender }</td>
					<td>${user.age }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>
<c:if test="${requestScope.result.status lt 0 }">
	<h3>用户列表读取失败 请稍后再看</h3>
</c:if>
</body>
</html>
