<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.bluesky.dao.InfoDao" %>
<%@ page import="com.bluesky.entity.Info" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="org.json.JSONArray" %>
<%@ page import="org.json.JSONException" %>
<%@ page import="org.json.JSONObject" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
<link rel="stylesheet" href="css/information.css">
<script src="./js/lib/jquery-2.1.1.min.js" type="text/javascript"></script>
</head>
<body>
		
			<div class="conson">
				
			</div>
			<div class="info_foot" style="position:absolute; top:57rem">
				<tr>
					<td><input type="button" value="下一页" class="btu_next"></td>
					&nbsp;&nbsp;&nbsp;
					<td><input type="button" value="上一页" class="btu_after"></td>
				</tr>
			</div>
</body>
<script type="text/javascript">
var type=2;
var start=0;
var end=8;
var i_index=0;
window.onload=function(){
	i_index=0;
	$.ajax({
		type:"GET",
		url:"http://39.105.34.171:8080/BlueSky/GetInfoServlet",
		contentType:'application/x-www-form-urlencoded;charset=utf-8',
		data:{type,start,end},
		dataType:"json",
		success:function(data){
			var $consons=$("div.conson");
			var s="";
			for(i in data){
				s+="<div class='cons' style='margin:1%' onclick=''><a href='#' target='view_window' id='sker'><div class='constop'><img src='image/logo.png'><span>魔豆公益</span></div><div class='consmiddle cor cen' id='title'>"+data[i].title+"</div><div class='consbottom cen' id='link1'><span></span></br></div></a></div>";
				i_index++ ;
			}
			console.log(i_index);
			if(i_index!=end){
				$(".btu_next").attr("disabled","true");
				i_index=0;
			}
			$consons.html(s);
			for(i in data){
				var $a_href=$("a#sker");
				var div_cons=document.getElementsByClassName("cons");
				div_cons[i].style.background="url("+data[i].img+")";
				div_cons[i].style.backgroundSize="100%";
				div_cons[i].style.backgroundRepeat="no-repeat";
				$a_href.attr("href",data[i].context);
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
		start+=8;
		$.ajax({
			type:"GET",
			url:"http://39.105.34.171:8080/BlueSky/GetInfoServlet",
			contentType:'application/x-www-form-urlencoded;charset=utf-8',
			data:{type,start,end},
			dataType:"json",
			success:function(data){
				var $consons=$("div.conson");
				var s="";
				for(i in data){
					s+="<div class='project_titlex' style='margin:1%'><div class='cons' style='margin:1%' onclick=''><a href='' target='view_window' id='sker'><div class='constop'><img src='image/logo.png'><span>魔豆公益</span></div><div class='consmiddle cor cen' id='title'>标题</div><div class='consbottom cen' id='link1'><span></span></br></div></a></div></div>";
				}
				if(i!=end){
					$(".btu_next").prop("disabled","true");
					i_index=0;
				}
				$consons.html(s);
				for(i in data){
					var $a_href=$("a#sker");
					var div_cons=document.getElementsByClassName("cons");
					div_cons[i].style.background="url("+data[i].img+")";
					div_cons[i].style.backgroundSize="100%";
					div_cons[i].style.backgroundRepeat="no-repeat";
					$a_href.attr("href",data[i].context);
				}
				
				
			},
			error:function(e){
				console.log("error");
				console.log(e);
			}
		});
		
	});
	$but_after.click(function(){
		start-=8;
		if(start<0){
			start=0;
		}else{
			$(".btu_next").removeAttr("disabled");
			$.ajax({
				type:"GET",
				url:"http://39.105.34.171:8080/BlueSky/GetInfoServlet",
				contentType:'application/x-www-form-urlencoded;charset=utf-8',
				data:{type,start,end},
				dataType:"json",
				success:function(data){
					var $a_href=$("a#sker");
					var $consons=$("div.conson");
					var s="";
					for(i in data){
						s+="<div class='project_titlex' style='margin:1%'><div class='cons' style='margin:1%' onclick=''><a href='' target='view_window' id='sker'><div class='constop'><img src='image/logo.png'><span>魔豆公益</span></div><div class='consmiddle cor cen' id='title'>标题</div><div class='consbottom cen' id='link1'><span></span></br></div></a></div></div>";
					}
					$consons.html(s);
					for(i in data){
						var $a_href=$("a#sker");
						var div_cons=document.getElementsByClassName("cons");
						div_cons[i].style.background="url("+data[i].img+")";
						div_cons[i].style.backgroundSize="100%";
						div_cons[i].style.backgroundRepeat="no-repeat";
						$a_href.attr("href",data[i].context);
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
</html>














