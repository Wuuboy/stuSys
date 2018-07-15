<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>登录界面</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>

	<link rel="stylesheet" type="text/css" href="${APP_PATH }/static/css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="${APP_PATH }/static/css/demo.css" />
	<!--必要样式-->
	<link rel="stylesheet" type="text/css" href="${APP_PATH }/static/css/component.css" />
</head>
<body>
	<div class="container demo-1">
		<div class="content">
			<div id="large-header" class="large-header">
				<canvas id="demo-canvas"></canvas>
				<div class="logo_box">
					<p id="p01" style="font-size: 30px; font-family:'微软雅黑';margin-left: 30px">学生成绩管理系统</p>
					<form action="${APP_PATH }/stu/login" method="post">
						<div class="input_outer">
							<span class="u_user"></span> 
							<input name="username" class="text"
								style="color: #FFFFFF !important; font-size:20px; " type="text"
								placeholder="请输入用户名">
						</div>
						<div class="input_outer">
							<span class="us_uer"></span> 
							<input name="password" class="text"
								style="color: #FFFFFF !important; font-size:20px; position:absolute; z-index:100;"
								 type="password" placeholder="请输入密码">
						</div>
						<div class="mb2">
							<button class="act-but submit"
								style="color: #FFFFFF; width: 325px; height: 50px;" >登录</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div style="text-align:center;">
		<!-- /container -->
		<script src="${APP_PATH }/static/js/login/TweenLite.min.js"></script>
		<script src="${APP_PATH }/static/js/login/EasePack.min.js"></script>
		<script src="${APP_PATH }/static/js/login/rAF.js"></script>
		<script src="${APP_PATH }/static/js/login/demo-1.js"></script>
	</div>
	
  </body>
</body>
</html>