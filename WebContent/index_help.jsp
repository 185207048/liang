<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.bluesky.dao.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="./js/lib/jquery-2.1.1.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="./index3_files/style.css">
<link rel="stylesheet" type="text/css" href="./index3_files/gongyi.css">
</head>
<body>
<%
		 String url="login.jsp";
	  	 int id=-1;
	  	
		 	if(session.getAttribute("type")!=null){
		 	id=Integer.parseInt(session.getAttribute("type").toString());
		 	}
			
			System.out.println(id);
			if(id==0){
				url="User.jsp";
			}else if(id==1){
				url="Teacher.jsp";
			}else if(id==3){
				url="User.jsp";
			}
		%>
<div class="title2"><li>申请资助</li></div>
       <div class="title3">
           <div class="title3-st">
               <div class="title3-nd-st">
                   <li>魔豆平台筹款中项目</li>
                   <li style="color: #ffffff;"><%=new ActivityDao().getCountStatus(0) %></li>
                   <li>个</li>
               </div>
               <div class="title3-nd-nd">
                   <li>执行中项目</li>
                   <li style="color: #ffffff;"><%=new ActivityDao().getCountStatus(1) %></li>
                   <li>个</li>
               </div>
               <div class="title3-nd-rd">
                   <li>已结束项目</li>
                   <li style="color: #ffffff;"><%=new ActivityDao().getCountStatus(2) %></li>
                   <li>个</li>
               </div>
           </div>
           <div class="title3-nd">
              <div><li><a href="<%=url %>" target="_top">申请资助</a></li></div>
           </div>
       </div>

       <div class="title2"><li>最新项目</li></div>
<div class="projects" style="width: 100%;"></div>
<div class="info_foot" style="position:absolute; top:131rem">
		<tr>
			<td><input type="button" value="下一页" class="btu_next"></td>
				&nbsp;&nbsp;&nbsp;
			<td><input type="button" value="上一页" class="btu_after"></td>
		</tr>
</div> 
<script type="text/javascript">
var status=0;
var start=0;
var end=12;
window.onload=function(){
	console.log("进入function");
	$.ajax({
		type:"GET",
		url:"http://39.105.34.171:8080/BlueSky/GetAllActivityByStatusServlet",
		contentType:'application/x-www-form-urlencoded;charset=utf-8',
		data:{status,start,end},
		dataType:"json",
		success:function(data){
			var id;
			var title;
			var money;
			var data_img=new Array();
			$project=$("div.projects");
			var s="";
			for(i in data){
				id=data[i].id;
				title=data[i].title;
				money=data[i].money;
				s+="<div class='projects-st'><div class='projects-img'><li style='line-height: 32rem;' class='project-name'>"+title+"</li></div><div class='projects-nd' class='project_money'><li>已获得"+money+"元资助</li></div><div class='projects-rd'><li><a target= '_top' href=http://39.105.34.171:8080/BlueSky/activity_2.jsp?subsidize="+id+">去资助 </a></li></div></div>";
				data_img[i]=data[i].img;
			}
			if(i!=end){
				$(".btu_next").prop("disabled","true");
			}
			$project.html(s);
			var projects_img=document.getElementsByClassName("projects-img");
			
			for(var i=0;i<projects_img.length;i++){
				projects_img[i].style.background="url("+data_img[i]+")";
				projects_img[i].style.mozBackgroundSize='100% 100%';
				projects_img[i].style.backgroundSize='100% 100%';
			}
		},
		error:function(e){
			console.log("error");
			console.log(e);
		}
	});
	$but_next=$("input.btu_next");
	$but_after=$("input.btu_after");
	$but_next.click(function(){
		start+=12;
		console.log("next");
		$.ajax({
			type:"GET",
			url:"http://39.105.34.171:8080/BlueSky/GetAllActivityByStatusServlet",
			contentType:'application/x-www-form-urlencoded;charset=utf-8',
			data:{status,start,end},
			dataType:"json",
			success:function(data){
				var id;
				var title;
				var money;
				var data_img=new Array();
				$project=$("div.projects");
				var s="";
				for(i in data){
					id=data[i].id;
					title=data[i].title;
					money=data[i].money;
					s+="<div class='projects-st'><div class='projects-img'><li style='line-height: 32rem;' class='project-name'>"+title+"</li></div><div class='projects-nd' class='project_money'><li>已获得"+money+"元资助</li></div><div class='projects-rd'><li><a target= '_top' href=http://39.105.34.171:8080/BlueSky/activity_2.jsp?subsidize="+id+">去资助 </a></li></div></div>";
					data_img[i]=data[i].img;
				}
				if(i!=end){
					$(".btu_next").prop("disabled","true");
				}
				$project.html(s);
				var projects_img=document.getElementsByClassName("projects-img");
				
				for(var i=0;i<projects_img.length;i++){
					projects_img[i].style.background="url("+data_img[i]+")";
					projects_img[i].style.mozBackgroundSize='100% 100%';
					projects_img[i].style.backgroundSize='100% 100%';
				}
			},
			error:function(e){
				console.log("error");
				console.log(e);
			}
		});
		
	});
	$but_after.click(function(){
		console.log("after");
		start-=12;
		if(start<0){
			start=0;
		}else{
			$(".btu_next").removeAttr("disabled");
			$.ajax({
				type:"GET",
				url:"http://39.105.34.171:8080/BlueSky/GetAllActivityByStatusServlet",
				contentType:'application/x-www-form-urlencoded;charset=utf-8',
				data:{status,start,end},
				dataType:"json",
				success:function(data){
					//$title_div.text(title);
					var id;
					var title;
					var money;
					var data_img=new Array();
					$project=$("div.projects");
					//console.log($project.text())
					//console.log(data[0]);
					var s="";
					for(i in data){
						//console.log(data[i]);
						id=data[i].id;
						title=data[i].title;
						money=data[i].money;
						s+="<div class='projects-st'><div class='projects-img'><li style='line-height: 32rem;' class='project-name'>"+title+"</li></div><div class='projects-nd' class='project_money'><li>已获得"+money+"元资助</li></div><div class='projects-rd'><li><a target= '_top' href=http://39.105.34.171:8080/BlueSky/activity_2.jsp?subsidize="+id+">去资助 </a></li></div></div>";
						data_img[i]=data[i].img;
					}
					$project.html(s);
					var projects_img=document.getElementsByClassName("projects-img");
					
					for(var i=0;i<projects_img.length;i++){
						//console.log(projects_img[i]);
						//console.log(data.img);
						projects_img[i].style.background="url("+data_img[i]+")";
						projects_img[i].style.mozBackgroundSize='100% 100%';
						projects_img[i].style.backgroundSize='100% 100%';
					}
				},
				error:function(e){
					console.log("error");
					console.log(e);
				}
			});
		}
	});
}
</script>
</body>
</html>