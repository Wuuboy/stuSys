<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生列表</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!-- web路径：
不以/开始的相对路径，找资源，以当前资源的路径为基准，经常容易出问题。
以/开始的相对路径，找资源，以服务器的路径为标准(http://localhost:3306)；需要加上项目名
		http://localhost:3306/crud
 -->
<script type="text/javascript"
	src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
<link
	href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${APP_PATH }/static/css/list.css" rel="stylesheet">
<script
	src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript">
//学号查询
function query(id) {  
    var id = id;
    $('#stuId_query_input').val(id); 
    //获取表格中的一行数据 
     //alert(id);
    var id_change=id%5;
    var name = document.getElementById("table").rows[id_change].cells[1].innerText;
    var sex = document.getElementById("table").rows[id_change].cells[2].innerText;  
    var birth = document.getElementById("table").rows[id_change].cells[3].innerText;  
    var java = document.getElementById("table").rows[id_change].cells[4].innerText;
    var math = document.getElementById("table").rows[id_change].cells[5].innerText; 
    var English = document.getElementById("table").rows[id_change].cells[6].innerText; 
    var PE = document.getElementById("table").rows[id_change].cells[7].innerText; 
    //向模态框中传值 
    $('#stuId_query_input').val(id);
    $('#stuName_query_input').val(name);
    if (sex == '男') {  
    	document.getElementById('sex1_update_input').checked = true;  
		} else {  
    	document.getElementById('sex2_update_input').checked = true;  
		}  
    $('#birth_query_input').val(birth);  
    $('#java_query_input').val(java);
    $('#math_query_input').val(math); 
    $('#english_query_input').val(English); 
    $('#pe_query_input').val(PE); 
    $('#stu_query_btn').modal('show');  
}  
//定义个方法提醒用户确定要删除吗？方法的参数就是要删除的id名  
function deleteStu(id){ 
            if(confirm("您确认删除吗？")){   
            //如果确定删除就访问servlet，这里超链接传值传的是方法里的参数           
            window.location.href="${APP_PATH}/stu/delete/"+id;  
        }  
    }
  
//触发更新模态框的同时调用此方法  
function editInfo(id) {  
    var id = id;
    $('#stuId_update_input').val(id); 
    //获取表格中的一行数据 
     //alert(id);
    var id_change=id%5;
    var name = document.getElementById("table").rows[id_change].cells[1].innerText;
    var sex = document.getElementById("table").rows[id_change].cells[2].innerText;  
    var birth = document.getElementById("table").rows[id_change].cells[3].innerText;  
    var java = document.getElementById("table").rows[id_change].cells[4].innerText;
    var math = document.getElementById("table").rows[id_change].cells[5].innerText; 
    var English = document.getElementById("table").rows[id_change].cells[6].innerText; 
    var PE = document.getElementById("table").rows[id_change].cells[7].innerText; 
    //向模态框中传值 
    $('#stuId_update_input').val(id);
    $('#stuName_update_input').val(name);
    if (sex == '男') {  
    	document.getElementById('sex1_update_input').checked = true;  
		} else {  
    	document.getElementById('sex2_update_input').checked = true;  
		}  
    $('#birth_update_input').val(birth);  
    $('#java_update_input').val(java);
    $('#math_update_input').val(math); 
    $('#english_update_input').val(English); 
    $('#pe_update_input').val(PE); 
    $('#stu_update_btn').modal('show');  
}  
//提交更改  
function update() {  
    //获取模态框数据  
    var id=$('#stuId_update_input').val();
    $.ajax({
		url:"${APP_PATH}/stu/update/"+id,
		type:"PUT",
		data:$("#myModal form").serialize(),
		success:function(result){
			//1、关闭对话框
			$("#myModal").modal("hide");
		}
	});
}  

//提交新增
function add() {
	$.ajax({
		url:"${APP_PATH}/stu/add_stu",
		type:"POST",
		data:$("#stuAddModal form").serialize(),
		success:function(result){
			//1、关闭对话框
			$("#stuAddModal").modal("hide");
		}
	});
}
//导出Excel
function excel() {
	 window.location.href="${APP_PATH}/stu/excel";
}

//返回
	function back_main() {
		window.location.href="${APP_PATH}/stu/back";
	}
</script>
</head>
<body class="list" background="${APP_PATH }/static/images/list/timg1.jfif" style="margin:0px auto">
<!-- 查询模态框 -->
<div class="modal fade" id="queryModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">学生信息修改</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal">
        
          <div class="form-group">
		    <label class="col-sm-2 control-label">id</label>
		    <div class="col-sm-10">
		      <input type="text" name="id" class="form-control" id="stuId_query_input" disabled="disabled">
		      <span class="help-block"></span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">Name</label>
		    <div class="col-sm-10">
		      <input type="text" name="name" class="form-control" id="stuName_query_input" placeholder="AAaa">
		      <span class="help-block"></span>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label class="col-sm-2 control-label">sex</label>
		    <div class="col-sm-10">
		      <label class="radio-inline">
				  <input type="radio" name="sex" id="sex1_query_input" value="M" checked="checked"> 男
				</label>
				<label class="radio-inline">
				  <input type="radio" name="sex" id="sex2_query_input" value="F"> 女
				</label>
		    </div>
		  </div>
		 <div class="form-group">
		    <label class="col-sm-2 control-label">birth</label>
		    <div class="col-sm-10">
		      <input type="text" name="birth" class="form-control" id="birth_query_input" placeholder="Tue May 29 00:00:00 CST 2018">
		      <span class="help-block"></span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">java</label>
		    <div class="col-sm-10">
		      <input type="text" name="java" class="form-control" id="java_query_input" placeholder="100.00">
		      <span class="help-block"></span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">math</label>
		    <div class="col-sm-10">
		      <input type="text" name="math" class="form-control" id="math_query_input" placeholder="100.00">
		      <span class="help-block"></span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">english</label>
		    <div class="col-sm-10">
		      <input type="text" name="english" class="form-control" id="english_query_input" placeholder="100.00">
		      <span class="help-block"></span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">pe</label>
		    <div class="col-sm-10">
		      <input type="text" name="pe" class="form-control" id="pe_query_input" placeholder="100.00">
		      <span class="help-block"></span>
		    </div>
		  </div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
      </div>
    </div>
  </div>
</div>
	<!-- 学生添加的模态框 -->
<div class="modal fade" id="stuAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">学生添加</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal">
		  <div class="form-group">
		    <label class="col-sm-2 control-label">Name</label>
		    <div class="col-sm-10">
		      <input type="text" name="name" class="form-control" id="stuName_add_input" placeholder="AAaa">
		      <span class="help-block"></span>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label class="col-sm-2 control-label">sex</label>
		    <div class="col-sm-10">
		      <label class="radio-inline">
				  <input type="radio" name="sex" id="sex1_add_input" value="M" checked="checked"> 男
				</label>
				<label class="radio-inline">
				  <input type="radio" name="sex" id="sex2_add_input" value="F"> 女
				</label>
		    </div>
		  </div>
		 <div class="form-group">
		    <label class="col-sm-2 control-label">birth</label>
		    <div class="col-sm-10">
		      <input type="text" name="birth" class="form-control" id="birth_add_input" placeholder="Tue May 29 00:00:00 CST 2018">
		      <span class="help-block"></span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">java</label>
		    <div class="col-sm-10">
		      <input type="text" name="java" class="form-control" id="java_add_input" placeholder="100.00">
		      <span class="help-block"></span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">math</label>
		    <div class="col-sm-10">
		      <input type="text" name="math" class="form-control" id="math_add_input" placeholder="100.00">
		      <span class="help-block"></span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">english</label>
		    <div class="col-sm-10">
		      <input type="text" name="english" class="form-control" id="english_add_input" placeholder="100.00">
		      <span class="help-block"></span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">pe</label>
		    <div class="col-sm-10">
		      <input type="text" name="pe" class="form-control" id="pe_add_input" placeholder="100.00">
		      <span class="help-block"></span>
		    </div>
		  </div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="stu_save_btn" onclick="add()">保存</button>
      </div>
    </div>
  </div>
</div>
	
<!-- 修改模态框 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">学生信息修改</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal">
        
          <div class="form-group">
		    <label class="col-sm-2 control-label">id</label>
		    <div class="col-sm-10">
		      <input type="text" name="id" class="form-control" id="stuId_update_input" disabled="disabled">
		      <span class="help-block"></span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">Name</label>
		    <div class="col-sm-10">
		      <input type="text" name="name" class="form-control" id="stuName_update_input" placeholder="AAaa">
		      <span class="help-block"></span>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label class="col-sm-2 control-label">sex</label>
		    <div class="col-sm-10">
		      <label class="radio-inline">
				  <input type="radio" name="sex" id="sex1_update_input" value="M" checked="checked"> 男
				</label>
				<label class="radio-inline">
				  <input type="radio" name="sex" id="sex2_update_input" value="F"> 女
				</label>
		    </div>
		  </div>
		 <div class="form-group">
		    <label class="col-sm-2 control-label">birth</label>
		    <div class="col-sm-10">
		      <input type="text" name="birth" class="form-control" id="birth_update_input" placeholder="Tue May 29 00:00:00 CST 2018">
		      <span class="help-block"></span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">java</label>
		    <div class="col-sm-10">
		      <input type="text" name="java" class="form-control" id="java_update_input" placeholder="100.00">
		      <span class="help-block"></span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">math</label>
		    <div class="col-sm-10">
		      <input type="text" name="math" class="form-control" id="math_update_input" placeholder="100.00">
		      <span class="help-block"></span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">english</label>
		    <div class="col-sm-10">
		      <input type="text" name="english" class="form-control" id="english_update_input" placeholder="100.00">
		      <span class="help-block"></span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">pe</label>
		    <div class="col-sm-10">
		      <input type="text" name="pe" class="form-control" id="pe_update_input" placeholder="100.00">
		      <span class="help-block"></span>
		    </div>
		  </div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="stu_update_btn" onclick="update()">确认更新</button>
      </div>
    </div>
  </div>
</div>
	
	<!-- 搭建显示页面 -->
	<div class="container">
		<!-- 标题 -->
		<div class="row">
			<div class="col-md-12">
				<h1 style="margin-left:400px">学生列表</h1>
			</div>
		</div>
		
		<button class="btn btn-primary" onclick="excel()" class="outExcell">导出Excell</button>
				&nbsp;&nbsp;
		<button class="btn btn-primary"  data-toggle="modal" data-target="#stuAddModal" class="newAdd">新增</button>
				&nbsp;&nbsp;
		<div class="number">
			<input id="id_input" type="text" name="id" placeholder="学号">
		    <button id="stu_query_btn" class="btn btn-primary" onclick="query($('#id_input').val())" data-toggle="modal" data-target="#queryModal">学号查询</button>
		</div>
		
		<form action="${APP_PATH }/stu/getStuByName" method="get" class="name">
		<input type="text" name="name" placeholder="姓名">
		<input class="btn btn-primary" type="submit" value="姓名查询">
		</form>	
		<!-- 显示表格数据 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover" id="table">
					<tr>
						<th>id</th>
						<th>name</th>
						<th>sex</th>
						<th>birth</th>
						<th>java</th>
						<th>math</th>
						<th>English</th>
						<th>PE</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${page.list }" var="stu">
						<tr>
							<th>${stu.id }</th>
							<th id="name">${stu.name }</th>
							<th>${stu.sex=="M"?"男":"女" }</th>
							<th>${stu.birth}</th>
						    <!--<th><fmt:formatDate value='${stu.birth}' pattern='yyyy-MM-dd'/></th>-->
							<th>${stu.java }</th>
							<th>${stu.math }</th>
							<th>${stu.english }</th>
							<th>${stu.pe }</th>
							<th>
								<button id="btn_update" class="btn btn-primary btn-sm" onclick="editInfo(${stu.id })" data-toggle="modal" data-target="#myModal">
									<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
									编辑
								</button> 
								 <button id="btn_delete"  class="btn btn-danger btn-sm" onclick="deleteStu(${stu.id})">
									<span class="glyphicon glyphicon-trash" aria-hidden="true" ></span>
									删除
								</button> 
							</th>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>

		<!-- 显示分页信息 -->
		<div class="row">
			<!--分页文字信息  -->
			<div class="col-md-6">当前 ${page.pageNum }页,总${page.pages }
				页,总 ${page.total } 条记录</div>
			<!-- 分页条信息 -->
			<div class="col-md-6">
				<nav aria-label="Page navigation">
				<ul class="pagination">
					<li><a href="${APP_PATH }/stu/list?pn=1">首页</a></li>
					<c:if test="${page.hasPreviousPage }">
						<li><a href="${APP_PATH }/stu/list?pn=${page.pageNum-1}"
							aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a></li>
					</c:if>


					<c:forEach items="${page.navigatepageNums }" var="page_Num">
						<c:if test="${page_Num == pageInfo.pageNum }">
							<li class="active"><a href="#">${page_Num }</a></li>
						</c:if>
						<c:if test="${page_Num != page.pageNum }">
							<li><a href="${APP_PATH }/stu/list?pn=${page_Num }">${page_Num }</a></li>
						</c:if>

					</c:forEach>
					<c:if test="${page.hasNextPage }">
						<li><a href="${APP_PATH }/stu/list?pn=${page.pageNum+1 }"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</c:if>
					<li><a href="${APP_PATH }/stu/list?pn=${page.pages}">末页</a></li>
				</ul>
				</nav>
			</div>
		</div>
	</div>
	<button onclick="back_main()">返回</button>
	
</body>
</html>