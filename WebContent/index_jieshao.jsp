<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html lang="zh"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" /> 
<title></title>
<link rel="stylesheet" type="text/css" href="./index3_files/style.css">
<link rel="stylesheet" type="text/css" href="./index3_files/gongyi.css">
<%@ page import="com.bluesky.dao.*" %>

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
        <div class="login"><a class="cor" href="<%=url%>">登陆</a></div>
        <div class="register"><a class="cor" href="register.html">注册</a></div>
    </div>
</div>
<section class="cd-hero">
  <div class="title-sec">
    
  </div>
  <nav class="cd-secondary-nav" id="tab">
	<ul>
		<li><a class="active">项目介绍</a></li>	
		<li><a>寻求帮助</a></li>
	</ul>
  </nav>

  </section> <!-- .cd-hero -->
<section class="part-one con" style="display: block;" >
	 <iframe src="index_allpro.jsp"></iframe>
</section>
<section class="part-one con" style="display: none; color:#000000;">
	  <iframe src="index_help.jsp"></iframe>
</section>
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
                <p>州患癌母亲周丽;红，她不仅</p>
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
<script src="./js/lib/jquery-2.1.1.min.js" type="text/javascript"></script>
<script src="./js/lib/main1.js"></script> <!-- Resource jQuery --> 
<script type="text/javascript" src="js/lib/raphael-min.js"></script>
<script type="text/javascript" src="js/res/chinaMapConfig.js"></script>
<script type="text/javascript" src="js/res/worldMapConfig.js"></script>
<script type="text/javascript" src="js/map.js"></script>
<script type="text/javascript" src="js/index.js"></script>
</body>
</html>