<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!-- web路径：
不以/开始的相对路径，找资源，以当前资源的路径为基准，经常容易出问题。
以/开始的相对路径，找资源，以服务器的路径为标准(http://localhost:3306)；需要加上项目名
		http://localhost:3306/crud
 -->
 <link href="${APP_PATH }/static/css/query_list.css"
	rel="stylesheet">
<script type="text/javascript"
	src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
<link
	href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>

<script type="text/javascript">
	function back() {
		window.location.href="${APP_PATH}/stu/list";
	}
</script>
<body class="query_list" background="${APP_PATH }/static/images/list/timg2.jfif">
<!-- 搭建显示页面 -->
	<div class="container">
		<!-- 标题 -->
		<div class="row">
			<div class="col-md-12">
				<h1>学生成绩列表</h1>
			</div>
		</div>
		
		<button class="btn btn-primary" onclick="back()">返回</button>
		
		<!-- 显示表格数据 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover">
					<tr>
						<th>id</th>
						<th>name</th>
						<th>java</th>
						<th>math</th>
						<th>English</th>
						<th>PE</th>
					</tr>
					<c:if test="${page==null}">
						confirm(a);
					</c:if>	
					<c:forEach items="${page}" var="stu">
						<tr>
							<th>${stu.id }</th>
							<th>${stu.name }</th>
							<th>${stu.java }</th>
							<th>${stu.math }</th>
							<th>${stu.english }</th>
							<th>${stu.pe }</th>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		</div>
</body>
</html>