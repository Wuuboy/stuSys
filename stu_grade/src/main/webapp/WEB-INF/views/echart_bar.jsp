<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人成绩柱状图</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
	<script type="text/javascript"
	src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="${APP_PATH }/static/js/echarts.min.js"></script>
</head>
<body>
	
	<!-- 显示Echarts图表 -->
		<div style="height:410px;min-height:100px;margin:0 auto;" id="main"></div>						
		
		<script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据
        var option = {
            title: {	//图表标题
                text: '学生成绩数据图表'
            },
            tooltip: {
                trigger: 'axis', //坐标轴触发提示框，多用于柱状、折线图中
            },
            dataZoom: [
                 {
                     type: 'slider',	//支持鼠标滚轮缩放
                     start: 0,			//默认数据初始缩放范围为10%到90%
                     end: 100
                 },
                 {
                     type: 'inside',	//支持单独的滑动条缩放
                     start: 0,			//默认数据初始缩放范围为10%到90%
                     end: 100
                 }
            ],
            legend: {	//图表上方的类别显示           	
            	show:true,
            	data:['java（分）','数学（分）','英语（分）','体育（分）']
            },
            color:[
                   '#FF3333',	//java图颜色
                   '#53FF53',	//数学图颜色
                   '#B15BFF',	//英语图颜色
                   '#68CFE8',	//体育图颜色
                   ],
           toolbox: {
               feature: {
                 dataView: {show: true, readOnly: false},
                 magicType: {show: true, type: ['line', 'bar']},
                 restore: {show: true},
                 saveAsImage: {show: true}
               }
             },
            xAxis:  {	//X轴       	
                type : 'category',
                data : []	//先设置数据值为空，后面用Ajax获取动态数据填入
            },
            yAxis : [	//Y轴（这里我设置了两个Y轴，左右各一个）
						{
            				//第一个（左边）Y轴，yAxisIndex为0
	                         type : 'value',
	                         name : '分数值',
	                         /* max: 120,
	                         min: -40, */
	                         axisLabel : {
	                             formatter: '{value} 分'	//控制输出格式
	                         }
	                     }
	                 
            ],
            series : [	//系列（内容）列表                      'java（分）','数学（分）','英语（分）','体育（分）
						{
		                    name:'成绩（分）',
		                    type:'bar',	//折线图表示（生成温度曲线）
		                    data:[]		//数据值通过Ajax动态获取
		                }
            ]
        };
		 
        
     	
      	//数据加载完之前先显示一段简单的loading动画
        myChart.showLoading();
      	//成绩数组
      	//var grades=[];
      	
      	 //var javas=[];		//java数组（存放服务器返回的所有温度值）
		 //var maths=[];		//math数组
		 //var englishs=[];		//english数组
		 //var pes=[];		//pe数组
		 
         $.ajax({	//使用JQuery内置的Ajax方法
         type : "post",		//post请求方式
         async : true,		//异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
         url : "${APP_PATH}/stu/echart_bar/"+${id},	//请求发送到ShowInfoIndexServlet处
        // data : {name:"A0001"},		//请求内包含一个key为name，value为A0001的参数；服务器接收到客户端请求时通过request.getParameter方法获取该参数值
         dataType : "json",		//返回数据形式为json
         success : function(result) {
        	 //请求成功时执行该函数内容，result即为服务器返回的json对象
	         if (result != null && result.length > 0) {
	                //for(var i=0;i<result.length;i++){       
	                  // javas.push(result[i].java);		//挨个取出温度、湿度、压强等值并填入前面声明的温度、湿度、压强等数组
	                //}
	                myChart.hideLoading();	//隐藏加载动画
	                
	                myChart.setOption({		//载入数据
	   		         xAxis: {
	   		             data: ['java','数学','英语','体育']	//填入X轴数据
	   		         },
	   		         series: [	//填入系列（内容）数据
	   		               		{
			   		             // 根据名字对应到相应的系列
			   		             name: '成绩',
			   		             data: result
	   		               		}
	   		        ]
	   		     });
	                
	         }
	         else {
	        	 //返回的数据为空时显示提示信息
	        	 alert("图表请求数据为空，可能服务器暂未录入数据，您可以稍后再试！");
	          	 myChart.hideLoading();
	         }
         
		},
     	error : function(errorMsg) {
     		//请求失败时执行该函数
         	alert("图表请求数据失败，可能是服务器开小差了");
         	myChart.hideLoading();    	
     	}
    })

    myChart.setOption(option);	//载入图表
           
    </script>
</body>
</html>