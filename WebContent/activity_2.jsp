<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.bluesky.dao.*" %>
<%@ page import="java.util.*"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.bluesky.entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css3/class.css">
	<link href="css3/bootstrap.css" type="text/css" rel="stylesheet" media="all">
    <link href="css3/style.css" type="text/css" rel="stylesheet" media="all">
	<!-- font-awesome icons -->
    <link href="css3/fontawesome-all.min.css" rel="stylesheet">
	<!-- //Custom Theme files -->
    <!-- online-fonts -->
	<link href="http://fonts.googleapis.com/css?family=Roboto:100i,400,500,700" rel="stylesheet">
	<link href="http://fonts.googleapis.com/css?family=Josefin+Sans:300,400,600,700" rel="stylesheet">
	<!-- //online-fonts -->
</head>
<body>
<%
	
	String subsidize=request.getParameter("subsidize");
	int sub= Integer.parseInt(subsidize);
	Activity activity= new ActivityDao().getActivityById(sub);

%>

<div class="contain-top">
    <div class="contain-top-logo cor">
        <div class="content-top-img"><img src="image/logo.png"/></div>
        <div class="contain-top-text">
            <div>
                湖畔魔豆
            </div>
            <div>
                HUPANMODOU
            </div>
        </div>
    </div>
    <div class="contain-top-nav cor cen">
        <ul>
            <li><a href="index.jsp">首页</a></li>
            <li><a href="about.jsp">关于魔豆</a></li>
            <li><a href="index_jieshao.jsp">魔豆公益</a></li>
            <li><a href="information_menu.jsp">信息公开</a></li>
            <li><a href="class.jsp?pages=1&details=1">魔豆讲堂</a></li>
            <li><a href="join.jsp">加入魔豆</a></li>
        </ul>
    </div>
    <div class="contain-top-login cen">
        <div class="login"><a class="cor" href="login.jsp">登陆</a></div>
        <div class="register"><a class="cor" href="register.html">注册</a></div>
    </div>
</div>
<div class="cd-main-content-img">
	<img src="image/yj.jpg"/>
</div>
<div class="content_activ" >
	<div class="container py-4 mt-2 " style="width:600px;">
			<h3 class="heading-agileinfo text-center">About<span> us</span></h3>
			<div class="inner_sec_info_wthree_agile mt-md-5 pt-3">
				
				<div  >
						<img src="<%=activity.getImg()%>" alt=" " class="img-fluid">
					</div>
						<br>
						<h1><%out.println(activity.getTitle()); %></h1>
						<div>
						<div style="word-break:break-all;">
							<p ><%out.println(activity.getInfo()+"\n"); %> </p>	
							
						</div>
						<div style="float:left">
						<table>
						<tr>
						<td>活动状态：</td>
						<td><%if(activity.getStatus()==0)
					out.println("活动正在筹款\n");
					else if(activity.getStatus()==1)
					out.println("活动正在进行\n");
					else if(activity.getStatus()==2)
					out.println("活动已结束\n");%></td>
						</tr>
						<tr>
							<td>目前筹款:</td>
							<td><%out.println(activity.getMoney()+"元"); %></td>
						</tr>
				
					
					</table>
						</div>	
						
						</div>
						
						
			</div>
		</div>
	
</div>
<div class="bottom">
    <div class="bottom-con">
        <div class="bottom-content">
            <div class="cor bottom-title">魔豆项目</div>
            <div class="bottom-mk1">
                <div class="bottom-mk1-k bottom-right bc1"></div>
                <div class="bottom-mk1-k bottom-right bc2"></div>
                <div class="bottom-mk1-k bc3"></div>
            </div>
            <div class="bottom-mk2">
                <div class="bottom-mk1-k bottom-right bc4"></div>
                <div class="bottom-mk1-k bottom-right bc5"></div>
                <div class="bottom-mk1-k bc6"></div>
            </div>
        </div>
        <div class="bottom-content">
            <div class="cor bottom-title">联系我们</div>
            <div class="bottom-rel cor">
                <p>“魔豆妈妈”这个词源于2002年苏州患癌母亲周丽红，她不仅坚“魔豆宝宝小屋”，维持自己和年幼女儿有尊严的生活。</p>
                <p>湖畔魔豆公益基金会理事长闻佳说：“因为我们是女性，所以我们所以我非常感谢彭蕾发起湖畔魔豆基金会，</p>
            </div>
            <div class="bottom-r">
                <div class="bottom-rx rx1"></div>
                <div class="bottom-rx rx2"></div>
                <div class="bottom-rx rx3"></div>
                <div class="bottom-rx rx4"></div>
                <div class="bottom-rx rx5"></div>
            </div>
        </div>
        <div class="bottom-content">
            <div class="cor bottom-title">关于我们</div>
            <div class="bottom-rel cor">
                <p>“魔豆妈妈”这个词源于2002年苏州患癌母亲周丽</p>
                <p>自己的淘宝店“魔豆宝宝小屋”，维持自</p>
                <p>州患癌母亲周丽红，她不仅</p>
                <p>持自己和年幼女儿有尊严的生活。</p>
                <p>红，她不仅坚强地与病魔作斗</p>
                <p>儿有尊严的生活。</p>
                <p>湖畔魔豆公益基金会理事长闻佳说：“因为我们是女性，所以我们所以我非常感谢彭蕾发起湖畔魔豆基金会，</p>
            </div>
        </div>
    </div>
    <div class="bottom-b">
        “魔豆妈妈”这个词源于2002年苏州患癌母亲周丽红，她不仅坚强地与病魔作斗争，还努力在网上经营自己的淘宝店
    </div>
</div>
<script src="js/jquery-2.1.1.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/class.js"></script>

</body>
</html>