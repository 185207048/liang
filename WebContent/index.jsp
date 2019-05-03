<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/index.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
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
       <div class="login"><a class="cor" href="<%=url%>">登陆</a></div>
        <div class="register"><a class="cor" href="register.html">注册</a></div>
    </div>
</div>
<div class="cd-main-content-img">
    <img src="image/index.jpg"/>
</div>
<div class="cd-navtop cen">
    <ul>
        <li><a href="#a">湖畔魔豆</a></li>
        <li><a href="#b">魔豆公益</a></li>
        <li><a href="#c">魔豆讲堂</a></li>
    </ul>
</div>
<div class="about" id="a">
    <div class="tall-title cen">
        关于魔豆
    </div>
    <div class="aboutcon">
        <div class="contain-join-left">
            <div class="concept-titleone">
                <div class="concept-title-border"></div>
                <div class="concept-title-font">
                    <div>魔豆的创立</div>
                    <div>About creation</div>
                </div>
            </div>
            <div class="about-text">
                <p>
                    “魔豆妈妈”这个词源于2002年苏州患癌母亲周丽红，她不仅坚强地与病魔作斗争，还努力在网上经营自己的淘宝店“魔豆宝宝小屋”，维持自己和年幼女儿有尊严的生活。2010年淘宝网捐赠1000万元在中国红十字会总会设立“中国红十字会淘宝公益基金”，主要资助开展“魔豆妈妈”项目，运用互联网的优势提升困难女性互联网创业、就业能力。至今，阿里巴巴已扶持5000多位“魔豆妈妈”。
                </p>
                <p>
                    “魔豆妈妈”这个词源于2002年苏州患癌母亲周丽红，她不仅坚强地与病魔作斗争，还努力在网上经营自己的淘宝店“魔豆宝宝小屋”，维持自己和年幼女儿有尊严的生活。2010年淘宝网捐赠1000万元在中国红十字会总会设立“中国红十字会淘宝公益基金”，主要资助开展“魔豆妈妈”项目，运用互联网的优势提升困难女性互联网创业、就业能力。至今，阿里巴巴已扶持5000多位“魔豆妈妈”。
                </p>
                <p>
                    “魔豆妈妈”这个词源于2002年苏州患癌母亲周丽红，她不仅坚强地与病魔作斗争，还努力在网上经营自己的淘宝店“魔豆宝宝小屋”，维持自己和年幼女儿有尊严的生活。2010年淘宝网捐赠1000万元在中国红十字会总会设立“中国红十字会淘宝公益基金”，主要资助开展“魔豆妈妈”项目，运用互联网的优势提升困难女性互联网创业、就业能力。至今，阿里巴巴已扶持5000多位“魔豆妈妈”。
                </p>
                <p>
                    “魔豆妈妈”这个词源于2002年苏州患癌母亲周丽红，她不仅坚强地与病魔作斗争，还努力在网上经营自己的淘宝店“魔豆宝宝小屋”，维持自己和年幼女儿有尊严的生活。2010年淘宝网捐赠1000万元在中国红十字会总会设立“中国红十字会淘宝公益基金”，主要资助开展“魔豆妈妈”项目，运用互联网的优势提升困难女性互联网创业、就业能力。至今，阿里巴巴已扶持5000多位“魔豆妈妈”。
                </p>
            </div>
        </div>
        <div class="contain-join-right">
            <img src="image/indexabout.jpg"/>
        </div>
    </div>
</div>
<div class="concept">
    <div class="concept-title">
        <div class="concept-title-border"></div>
        <div class="concept-title-font">
            <div>魔豆理念</div>
            <div>About concept</div>
        </div>
    </div>
    <div class="concept-p concept-p1">
        “魔豆妈妈”这个词源于2002年苏州患癌母亲周丽红，她不仅坚强地与病魔作斗争，
        还努力在网上经营自己的淘宝店“魔豆宝宝小屋”，维持自己和年幼女儿有尊严的生活。
        2010年淘宝网捐赠1000万元在中国红十字会总会设立“中国红十字会淘宝公益基金”，主要资助开展“魔豆妈妈”项目，
        运用互联网的优势提升困难女性互联网创业、就业能力。
    </div>
    <div class="concept-p concept-p2">
        至今，阿里巴巴已扶持5000多位“魔豆妈妈”。“魔豆妈妈”这个词源于2002年苏州患癌母亲周丽红，她不仅坚强地与病魔作斗争，
        还努力在网上经营自己的淘宝店“魔豆宝宝小屋”，维持自己和年幼女儿有尊严的生活。2010年淘宝网捐赠1000万元在中国红十字
        会总会设立“中国红十字会淘宝公益基金”，主要资助开展“魔豆妈妈”项目，运用互联网的优势提升困难女性互联网创业、就业能力。
        至今，阿里巴巴已扶持5000多位“魔豆妈妈”。
    </div>
    <div class="concept-m">
        <div class="concept-ms">
            <div class="cen cor concept-ms-title">
                <div>价值观</div>
                <div>Values</div>
            </div>
            <div class="cor concept-ms-text">
                “魔豆妈妈”这个词源于2002年苏州患癌母亲周丽红，她不仅坚强地与病魔作斗争，还努力在网上经营自己的淘宝店“魔豆宝宝小屋”，
                维持自己和年幼女儿有尊严的生活。
            </div>
        </div>
        <div class="concept-ms middle">
            <div class="cen cor concept-ms-title">
                <div>价值观</div>
                <div>Values</div>
                </div>
            <div class="cor concept-ms-text">
                “魔豆妈妈”这个词源于2002年苏州患癌母亲周丽红，她不仅坚强地与病魔作斗争，还努力在网上经营自己的淘宝店“魔豆宝宝小屋”，
                维持自己和年幼女儿有尊严的生活。
            </div>
        </div>
        <div class="concept-ms">
            <div class="cen cor concept-ms-title">
                <div>价值观</div>
                <div>Values</div>
            </div>
            <div class="cor concept-ms-text">
                 “魔豆妈妈”这个词源于2002年苏州患癌母亲周丽红，她不仅坚强地与病魔作斗争，还努力在网上经营自己的淘宝店“魔豆宝宝小屋”，
                 维持自己和年幼女儿有尊严的生活。
            </div>
        </div>
    </div>
</div>
<div class="tall cen" id="b">
    <div class="tall-title cen">
        魔豆公益
    </div>
    <div class="welfare">
        <div class="welfare-ms welfare-p1">
            <div class="welfare-ms1"></div>
            <div class="welfare-ms2 cor">
                <div class="welfare-c"><a href="<%=url%>">申请资助快速入口</a></div>
                <div class="welfare-ms2-m2">Apply for Financial</div>
            </div>
        </div>
        <div class="welfare-ms welfare-p2">
            <div class="welfare-ms1"></div>
            <div class="welfare-ms2 cor">
                <div class="welfare-c"><a href="join.jsp">加入魔豆入口</a></div>
                <div class="welfare-ms2-m2">Join Us</div>
            </div>
        </div>
        <div class="welfare-ms welfare-p3">
            <div class="welfare-ms1"></div>
            <div class="welfare-ms2 cor">
                <div class="welfare-c"><a href="index_jieshao.jsp">魔豆故事<a></a></div>
                <div class="welfare-ms2-m2">Modou Stories</div>
            </div>
        </div>
    </div>
</div>
<div class="tall cen" id="c">
    <div class="tall-title cen">
        魔豆讲堂
    </div>
    <div class="forum">
        <div class="forum-m1 forum-m1-right lbc">
            <div class="forum-text cen cor">
                <div><a href="class.jsp?pages=1&details=1">女性赋能</a></div>
                <div>Female Empoverment</div>
            </div>
        </div>
        <div class="forum-m2"></div>
        <div class="forum-m1 forum-m1-left rbc">
            <div class="forum-text cen cor">
                <div><a href="class.jsp?pages=1&details=0">0-3岁儿童</a></div>
                <div>Children age 0-3</div>
            </div>
        </div>
    </div>
</div>
<div class="tall cen">
    <div class="tall-title cen">
        合作企业
    </div>
    <div class="contain-ordblocktop">
        <div class="btop1">
            <img src="image/1-1.jpg"/>
        </div>
        <div class="btop2">
            <img src="image/1-2.jpg"/>
        </div>
        <div class="btop3">
            <img src="image/1-3.jpg"/>
        </div>
        <div class="btop4">
            <img src="image/1-4.jpg"/>
        </div>
        <div class="btop5">
            <img src="image/1-5.jpg"/>
        </div>
        <div class="btop6">
            <img src="image/1-6.jpg"/>
        </div>
        <div class="btop7">
            <img src="image/1-7.jpg"/>
        </div>
        <div class="btop8">
            <img src="image/1-8.jpg"/>
        </div>
        <div class="btop9">
            <img src="image/1-9.jpg"/>
        </div>
        <div class="btop10">
            <img src="image/1-10.jpg"/>
        </div>
    </div>
    <div class="contain-ordblockbottom">
        <div class="bottom1">
            <img src="image/2-1.jpg"/>
        </div>
        <div class="bottom2">
            <img src="image/2-2.jpg"/>
        </div>
        <div class="bottom3">
            <img src="image/2-3.jpg"/>
        </div>
        <div class="bottom4">
            <img src="image/2-4.jpg"/>
        </div>
        <div class="bottom5">
            <img src="image/2-5.jpg"/>
        </div>
        <div class="bottom6">
            <img src="image/2-6.jpg"/>
        </div>
        <div class="bottom7">
            <img src="image/2-7.jpg"/>
        </div>
        <div class="bottom8">
            <img src="image/2-8.jpg"/>
        </div>
        <div class="bottom9">
            <img src="image/2-9.jpg"/>
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
<script type="text/javascript" src="js/index.js"></script>
</body>
</html>