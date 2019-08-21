<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" >
<html>
<head>
	<title>无权限页面</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, 
                                     initial-scale=1.0, 
                                     maximum-scale=1.0, 
                                     user-scalable=no">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">
    <meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
	<link href="<%=request.getContextPath() %>/resources/js/bootstrap/bootstrap.min.css" rel="stylesheet">
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.9.1.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/bootstrap/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
	<h2>Hello World!</h2>
	<div class="container">
		<h2>温馨提示：权限不足，请核实。</h2>
	</div>
</body>
</html>
