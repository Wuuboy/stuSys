<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页面</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<link href="${APP_PATH }/static/css/main.css" rel="stylesheet">
</head>
<body background="${APP_PATH }/static/images/main/timg.jfif" class="top">

<div id="container" >
	<a class="navbar-brand" href="#" id="logo">学生成绩管理系统</a>
		
	
	<ul id="main-nav" class="nav nav-tabs nav-stacked">
		<li>
			<a href="${APP_PATH }/stu/list"> 
					<div class="first">学生信息 </div>
			</a>
		</li>
		<li>
		<a href="#"> 
		<div class="second">学生成绩</div>
		</a>
		</li>
		<li>
		<a href="${APP_PATH }/echart_bar1.jsp"> 
		<div class="third">柱状图</div>
		</a>
		</li>
		</ul>
		<form action="${APP_PATH }/stu/echart" method="get">
				<input id="id_input" type="text" name="id" placeholder="请输入要查询的学号">
				<input type="submit" value="柱状图">
		</form>
	
</div>
	
	
</body>
</html>