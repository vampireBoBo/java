<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="../comm.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>音乐列表</title>
</head>
<body>
	<div class="container">
		<table class="table" role="table">
			<caption style="text-align:right;"><button>创建</button></caption>
			<thead>
				<tr>
					<th>编号</th>
					<th>名称</th>
					<th>作者</th>
					<th>创建时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="music" varStatus="status">
					<tr>
						<td>${music.id }</td>
						<td>${music.name }</td>
						<td>${music.author }</td>
						<td><fmt:formatDate value="${music.createTime}" type="date"/></td>
						<td>
							<button>修改</button>
							<button>删除</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>