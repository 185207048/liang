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
<link rel="stylesheet" type="text/css" href="./index3_files/style.css">
<link rel="stylesheet" type="text/css" href="./index3_files/gongyi.css">
<div class="title-rd"><li>我们的项目</li></div>
<div class="title3">
           <div class="title3-st">
               <div class="title3-nd-st">
                   <li>魔豆平台中共有</li>
                   <li style="color: #ffffff;" id="allObj"></li>
                   <li>个项目</li>
               </div>
</div>
<div class="movePic">
	<div class="movePic-top">
		<ul class = "imgList">
		</ul>
	</div>
</div>
<div class="title-rd1" style=""><li>项目动态</li></div>
<div class="projects"></div>
<div class="info_foot" style="position:absolute; top:131rem">
		<tr>
			<td><input type="button" value="下一页" class="btu_next"></td>
				&nbsp;&nbsp;&nbsp;
			<td><input type="button" value="上一页" class="btu_after"></td>
		</tr>
</div> 
<script type="text/javascript" src="./js/tools.js"></script>
<script type="text/javascript">
var start=0;
var end=9;
window.onload=function(){
	//***************************轮播图*****************************
	$.ajax({
		type:"GET",
		url:"http://39.105.34.171:8080/BlueSky/GetAllActivityServlet",
		contentType:'application/x-www-form-urlencoded;charset=utf-8',
		data:{start,end},
		dataType:"json",
		success:function(data){
			//console.log(data[0].id);
				var imgList = document.getElementsByClassName("imgList")[0];
				var s="";
				var index=0;
				for(var i =0 ; i <data.length; i++ ){
					s+="<li  style='display:inline-block'><a class='img_cv' target = '_top' href=activity_2.jsp?subsidize="+data[i].id+" style='display:block;margin:1rem 0.1rem 0 0;display:inline-block;width:25rem;height:15rem;background:url("+data[i].img+") 0% 0% / 100% 100%;'></a></li>";
				}
				var img_cv=document.getElementsByClassName("img_cv");
				var movePic = document.getElementsByClassName("movePic")[0];
				imgList.innerHTML = s;
				//here*********/////
				//console.log(img_cv);
				var imgList = document.getElementsByClassName("imgList")[0];
				var body = document.getElementsByTagName("body")[0];
				//console.log("body-width:"+getStyle(body,"width"));
			
				setInterval(function(){
					index++;
					var current = parseInt(getStyle(imgList,"left"));
					imgList.style.left = (current-4) + "px";
					//console.log("img-width:"+imgList.style.left);
					if(img_cv.length<15){
						//console.log("x1");
						imgList.innerHTML += s;
					}
					if(index>40){
						index=0;
						//console.log("x2");
						imgList.innerHTML += s;
					}
				},100);
		},
		error:function(e){
			console.log("error");
			console.log(e);
		}
	});
	//***************************轮播图************************GetActivityServlet
	$.ajax({
		type:"GET",
		url:"http://39.105.34.171:8080/BlueSky/GetAllActivityServlet",
		contentType:'application/x-www-form-urlencoded;charset=utf-8',
		data:{start,end},
		dataType:"json",
		success:function(data){
			//$title_div.text(title);
			var id;
			var title;
			var money;
			var index=0;
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
				index++;
				
			}
			//console.log(index);
			var allobj = document.getElementById("allObj");
			allobj.innerHTML+=index;
			if(index!=end){
				$(".btu_next").prop("disabled","true");
			}
			$project.html(s);
			var projects_img=document.getElementsByClassName("projects-img");
			//here*********/////
			console.log(projects_img);
			for(var i=0;i<projects_img.length;i++){
				//console.log("projects_img[i]:"+projects_img[i]);
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
		start+=9;
		console.log("next");
		$.ajax({
			type:"GET",
			url:"http://39.105.34.171:8080/BlueSky/GetAllActivityServlet",
			contentType:'application/x-www-form-urlencoded;charset=utf-8',
			data:{start,end},
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
				if(i!=end){
					$(".btu_next").prop("disabled","true");
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
		
	});
	$but_after.click(function(){
		console.log("after");
		start-=9;
		if(start<0){
			start=0;
		}else{
			$(".btu_next").removeAttr("disabled");
			$.ajax({
				type:"GET",
				url:"http://39.105.34.171:8080/BlueSky/GetAllActivityServlet",
				contentType:'application/x-www-form-urlencoded;charset=utf-8',
				data:{start,end},
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