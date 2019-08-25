<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="../comm.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>
	<div class="container">
		
		<table class="table" role="table">
			<caption style="text-align:right;"><shiro:hasPermission name="user:all"><button>创建</button></shiro:hasPermission></caption>
			<thead>
				<tr>
					<th>账号</th>
					<th>姓名</th>
					<th>性别</th>
					<th>年龄</th>
					<th>电话</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="user">
					<tr>
						<td>${user.username}</td>
						<td>${user.name }</td>
						<td>${user.gender}</td>
						<td>${user.age}</td>
						<td>${user.phone}</td>
						<td>
							<shiro:hasPermission name="user:all">
								<button>修改</button>
								<button>删除</button>
							</shiro:hasPermission>
							<shiro:hasPermission name="user:update">
								<button>修改</button>
							</shiro:hasPermission>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>