<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/join.css">
<meta charset="utf-8">
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
<div class="contain">
    <div class="contain-fill cen cor">
    	加入魔豆
    </div>
    <div class="contain-nav cen">
    	<ul>
    		<li><a href="#a">成为讲师</a></li>
    		<li><a href="#b">加入我们</a></li>
    		<li><a href="#c">公益组织</a></li>
    		<li><a href="#d">爱心企业</a></li>
    		<li><a href="#e">联系我们</a></li>
    	</ul>
    </div>
    <div class="contain-teacher cen" id="a">
    	成为讲师
    </div>
    <div class="contain-teacher-con">
    	<div class="contain-teacher-left">
    		<div class="left-top">
                <img src="image/tobeteach.jpg">
            </div>
    		<div class="left-bottom">
    			<div>请下载下方申请表格，填写个人信息后提交至邮箱：md@hupanmodou.org</div>
    			<div class="left-bottom-b"><a hre="#">《湖畔魔豆基金会志愿者管理手册》下载.doc</a></div>
    		</div>
    	</div>
    	<div class="contain-teacher-right">
    		<div class="contain-teacher-right-m1">
    			讲师任职资格：<br/>
					1.  市场营销、新闻、管理类相关专业本科以上学历，五年以上媒介工作经验，能够独立完成工作；<br/>
					2.  熟悉各类媒体运作流程，媒体资源丰富，熟悉媒介市场行情及各种宣传推广方法的操作流程；<br/>
					3.  具备优秀的写作能力，并能与多方媒体保持良好的合作关系；<br/>
					4.  具备一定策划能力，有成熟的网络推广经验及成功案例，能独立策划及执行推广活动；<br/>
					5.  性格开朗，善于人际关系的协调和沟通；<br/>
					6.  具有良好的团队合作,执行力高，有良好的职业道德，能承受工作压力；<br/>
					7.  愿意长期从事公益事业，认同本机构发展理念，能与机构共同成长。<br/>
					8.  制定公募基金年度品牌推广计划，提高公募基金会知名度；<br/>
					9.  挖掘及整合运用媒体资源、网络资源，策划及执行各类推广活动；<br/><br/>

					负责公募基金推广体系的建立及实施； <br/>
					维护各类媒体关系，拓展与各类媒体的广泛合作，负责媒体文章的撰写、发稿及相关事宜；<br/>
					配合进行筹款类活动策划和执行。
    		</div>
    		<div class="contain-teacher-right-m2">
    			       只要你热爱慈善事业，认同爱佑慈善基金会的价值观及理念，并在不计物质报酬的前提下，自愿以力所能及的方式贡献个人的时间、精力、专业知识与技能，就有机会成为爱佑慈善基金会的志愿者，为基金会提供无偿志愿服务。<br/><br/>

						讲师职责：<br/>
						1.  制定公募基金年度品牌推广计划，提高公募基金会知名度；<br/>
						2.  挖掘及整合运用媒体资源、网络资源，策划及执行各类推广活动；<br/>
						3.  负责公募基金推广体系的建立及实施； <br/>
						4.  维护各类媒体关系，拓展与各类媒体的广泛合作，负责媒体文章的撰写、发稿及相关事宜；<br/>
						5.  配合进行筹款类活动策划和执行。
    		</div>
    	</div>
    </div>
    <div class="contain-teacher cen" id="b">
    	加入我们
    </div>
    <div class="contain-join">
    	<div class="contain-join-left">
            <img src="image/tobevoleen.jpg"/>
    	</div>
    	<div class="contain-join-right">
    		<div class="contain-join-right-top">
    			只要你热爱慈善事业，认同爱佑慈善基金会的价值观及理念，并在不计物质报酬的前提下，自愿以力所能及的方式贡献个人的时间、精力、专业知识与技能，就有机会成为爱佑慈善基金会的志愿者，为基金会提供无偿志愿服务。<br/><br/>

					志愿者职责：<br/>
					1.  制定公募基金年度品牌推广计划，提高公募基金会知名度；<br/>
					2.  挖掘及整合运用媒体资源、网络资源，策划及执行各类推广活动；<br/>
					3.  负责公募基金推广体系的建立及实施； <br/>
					4.  维护各类媒体关系，拓展与各类媒体的广泛合作，负责媒体文章的撰写、发稿及相关事宜；<br/>
					5.  配合进行筹款类活动策划和执行。
    		</div>
    		<div class="contain-join-right-bottom">
    			<div>请下载下方申请表格，填写个人信息后提交至邮箱：md@hupanmodou.org</div>
    			<div class="contain-join-mtop">
                    <img src="image/icon.png"/>
                    <span>《湖畔魔豆基金会志愿者管理手册》下载.doc</span>
                </div>
    		</div>
    	</div>
    </div>
    <div class="contain-teacher cen" id="c">
    	公益组织
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
    <div class="contain-teacher cen" id="d">
        爱心企业
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
    <div class="contain-teacher cen" id="e">
        联系我们
    </div>
    <div class="contain-relat">
        <div class="contain-relat-l">
            <img src="image/relative.jpg"/>
        </div>
        <div class="contain-relat-r">
            <div class="contain-relat-rs">
                <img src="image/icon-addr.png"/>
                <span>地址：北京市海淀区XXXX大街乙11号XX大厦27层1111室</span><br/>
                <span>邮编：100000</span>
            </div>
            <div class="contain-relat-rs rs-max">
                <img src="image/icon-phone.png"/>
                <span>联系电话：+86 (10) 111111111</span>
                <span>监督及反馈：+86 (10)11111111-121，监督小组</span>
            </div>
            <div class="contain-relat-rs rs-max">
                <img src="image/icon-cz.png"/>
                <span class="mtop">传真：+86 (10) 12121212</span>
            </div>
            <div class="contain-relat-rs rs-max">
                <img src="image/icon-email.png"/>
                <span class="mtop">邮箱：md@hupanmodou.org</span>
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
<script src="js/join.js"></script>
</body>
</html>