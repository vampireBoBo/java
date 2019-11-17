<%@page language="java" pageEncoding="UTF-8"%>
<html>
<body>
<h2>欢迎使用 1102demo</h2>
	<form action="<%=request.getContextPath()%>/spring/index/login" method="post">
		账号:<input type="text" name="username"><br>
		密码:<input type="password" name="password"><br/>
		<button>登录</button>
	</form>
</body>
</html>
