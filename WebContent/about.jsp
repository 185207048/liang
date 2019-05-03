<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/about.css">
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
<div class="cd-main-content-img">
	<img src="image/about.jpg"/>
</div>

<div class="cd-main-content" id="tab">
	<div class="cd-nav">
		<ul>
			<li><a class="tab_btn on">魔豆的创立</a></li>
		    <li><a class="tab_btn">魔豆的创始人</a></li> 
		    <li><a class="tab_btn">魔豆理念</a></li> 
		</ul>
	</div>
	<div class="content-first con" style="display: block;">
		<div class="cons-first">
			<div class="cons-title">
				<div>魔豆的创立</div>
				<div class="cons-title-top">About Create</div>
			</div>
			<div class="cons-content-first">
				<div class="cons-content-left">
					<p>“魔豆妈妈”这个词源于2002年苏州患癌母亲周丽红，她不仅坚强地与病魔作斗争，还努力在网上经营自己的淘宝店“魔豆宝宝小屋”，维持自己和年幼女儿有尊严的生活。2010年淘宝网捐赠1000万元在中国红十字会总会设立“中国红十字会淘宝公益基金”，主要资助开展“魔豆妈妈”项目，运用互联网的优势提升困难女性互联网创业、就业能力。至今，阿里巴巴已扶持5000多位“魔豆妈妈”。</p>

					<p>“魔豆妈妈”这个词源于2002年苏州患癌母亲周丽红，她不仅坚强地与病魔作斗争，还努力在网上经营自己的淘宝店“魔豆宝宝小屋”，维持自己和年幼女儿有尊严的生活。2010年淘宝网捐赠1000万元在中国红十字会总会设立“中国红十字会淘宝公益基金”，主要资助开展“魔豆妈妈”项目，运用互联网的优势提升困难女性互联网创业、</p>

					<p>“魔豆妈妈”这个词源于2002年苏州患癌母亲周丽红，她不仅坚强地与病魔作斗争，还努力在网上经营自己的淘宝店“魔豆宝宝小屋”，维持自己和年幼女儿有尊严的生活。2010年淘宝网捐赠1000万元在中国红十字会总会设立“中国红十字会淘宝公益基金”，主要资助开展“魔豆妈妈”项目，运用互联网的优势提升困难女性互联网创业、就业能力。至今，阿里巴巴已扶持5000多位“魔豆妈妈”。“魔豆妈妈”这个词源于2002年苏州患癌母亲周丽红，她不仅坚强地与病魔作斗争，还努力在网上经营自己的淘宝店“魔豆宝宝小屋”，维持自己和年幼女儿有尊严的生活。20至今，阿里巴巴已扶持5000多位“魔豆妈妈”。“魔豆妈妈”这个词源于2002年苏州患癌母亲周丽红，她不仅坚强地与病魔作斗争，还努力在网上经营自己的淘宝店“魔豆宝宝小屋”，维持自己和年幼女儿有尊严的生活。20至今，阿里巴巴已扶持5000多位“魔豆妈妈”。“魔豆妈妈”这个词源于2002年苏州患癌母亲周丽红，她不仅坚强地与病魔作斗争，还努力在网上经营自己的淘宝店“魔豆宝宝小屋”，维持自己和年幼女儿有尊严的生活。</p>
				</div>
				<div class="cons-content-right">
					<img src="image/create.png" />
				</div>
			</div>
		</div>
	</div>
	<div class="content con">
		<div class="cons">
			<div class="cons-title">
				<div>魔豆的创始人</div>
				<div class="cons-title-top">About Founders</div>
			</div>
			<div class="cons-text">
				12位女合伙人成立“湖畔魔豆”公益基金希望这个世界更美好、更温暖。马云“背后的女人”站出来 昨种下爱的种子，在阿里巴巴内各自掌管一方，有着明锐的商业触觉，而她们更有着一个天然的角色——母亲和妻子，拥有着一颗细腻而柔软的心。彭蕾、武卫、童文红、吴敏芝、戴珊、蒋芳、郑俊芳、闻佳、彭翼捷、俞思瑛、张宇、赵颖，阿里巴巴全部12位女性合伙人站在台上，排得整整齐齐，略显紧张。这可能是12女性合伙人第一次集体公开亮相，在昨天（9月8日）阿里18周年这一天，这12位马云“背后的女人”要向台下的百余位阿里老友公
			</div>
			<div class="zy-Slide">
				<!--prev:元素中的文本通常会保留空格和换行符。而文本也会呈现为等宽字体。-->
				<div class="zy-qh">
					<section>
						<img src="image/left.png"/>
					</section>
					<section>
						<img src="image/right.png"/>
					</section>
				</div>
				<ul>
					<!--alt + shift : 可以创建一个矩形选择区域-->
					<li><img src="image/1.jpg" /></li>
					<li><img src="image/2.jpg" /></li>
					<li><img src="image/3.jpg" /></li>
					<li><img src="image/4.jpg" /></li>
					<li><img src="image/5.jpg" /></li>
					<li><img src="image/6.jpg" /></li>
					<li><img src="image/7.jpg" /></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="content con">
		<div class="cons">
			<div class="cons-title">
				<div>魔豆理念</div>
				<div class="cons-title-top">About Concept</div>
			</div>
			<div class="cons-text">
				<p>
					“魔豆妈妈”这个词源于2002年苏州患癌母亲周丽红，她不仅坚强地与病魔作斗争，还努力在网上经营自己的淘宝店“魔豆宝宝小屋”，维持自己和年幼女儿有尊严的生活。2010年淘宝网捐赠1000万元在中国红十字会总会设立“中国红十字会淘宝公益基金”，主要资助开展“魔豆妈妈”项目，运用互联网的优势提升困难女性互联网创业、就业能力。
				</p>
				<p class="cons-concept-top">
					至今，阿里巴巴已扶持5000多位“魔豆妈妈”。“魔豆妈妈”这个词源于2002年苏州患癌母亲周丽红，她不仅坚强地与病魔作斗争，还努力在网上经营自己的淘宝店“魔豆宝宝小屋”，维持自己和年幼女儿有尊严的生活。2010年淘宝网捐赠1000万元在中国红十字会总会设立“中国红十字会淘宝公益基金”，主要资助开展“魔豆妈妈”项目，运用互联网的优势提升困难女性互联网创业、就业能力。至今，阿里巴巴已扶持5000多位“魔豆妈妈”。
				</p>
			</div>
			<div class="cons-moudle cor cen bk1">
				<div class="moudle-top">
					<span class="big">价值观</span>
					<div class="br"></div>
					<span>热忱</span><span>正直</span><span>高效</span>
				</div>
			</div>
			<div class="cons-moudle cor cen bk11" id="bk11">
				<div class="moudle-top small">
					<div class="fonts">
						我们鼓励所有人都参与创建有利于保护儿童的社会环境。在发生突发事件时或者在儿童权利面临威胁的情况下，我们致力于减轻儿童所受到的伤害，因为任何孩子都不应当遭受暴力、虐待或者剥削的伤害。您可以为改善全世界儿童的生活贡献自己的力量。请立即采取行动，了解怎样做能够促进儿童权利。您还可以通过其他途径支持我们的工作。我们重点关注如何为婴幼儿提供适当的照顾，以便为他们的将来打下最坚实的基础。
					</div><br/>
					<div class="small-span fonts">
						我们帮助所有儿童获得优质的基础教育。男童和女童享受平等的教育将惠及社会上的所有人。受过教育的儿童长大后会成为更好的思想者、更优秀的公民，也会成为更称职的家长。
					</div>
				</div>
			</div>
			<div class="cons-moudle cor cen bk2">
				<div class="moudle-top">
					<span class="big">使命</span>
					<div class="br"></div>
					<span>让公益成为每个人的生活方式</span>
				</div>
			</div>
			<div class="cons-moudle cor cen bk22" id="bk22">
				<div class="moudle-top small">
					<div class="fonts">
						我们鼓励所有人都参与创建有利于保护儿童的社会环境。在发生突发事件时或者在儿童权利面临威胁的情况下，我们致力于减轻儿童所受到的伤害，因为任何孩子都不应当遭受暴力、虐待或者剥削的伤害。您可以为改善全世界儿童的生活贡献自己的力量。请立即采取行动，了解怎样做能够促进儿童权利。您还可以通过其他途径支持我们的工作。我们重点关注如何为婴幼儿提供适当的照顾，以便为他们的将来打下最坚实的基础。
					</div><br/>
					<div class="small-span fonts">
						我们帮助所有儿童获得优质的基础教育。男童和女童享受平等的教育将惠及社会上的所有人。受过教育的儿童长大后会成为更好的思想者、更优秀的公民，也会成为更称职的家长。
					</div>
				</div>
			</div>
			<div class="cons-moudle cor cen bk3">
				<div class="moudle-top">
					<span class="big">愿景</span>
					<div class="br"></div>
					<span>成为全球公益领航者</span>
				</div>
			</div>
			<div class="cons-moudle cor cen bk33" id="bk33">
				<div class="moudle-top small">
					<div class="fonts">
						我们鼓励所有人都参与创建有利于保护儿童的社会环境。在发生突发事件时或者在儿童权利面临威胁的情况下，我们致力于减轻儿童所受到的伤害，因为任何孩子都不应当遭受暴力、虐待或者剥削的伤害。您可以为改善全世界儿童的生活贡献自己的力量。请立即采取行动，了解怎样做能够促进儿童权利。您还可以通过其他途径支持我们的工作。我们重点关注如何为婴幼儿提供适当的照顾，以便为他们的将来打下最坚实的基础。
					</div><br/>
					<div class="small-span fonts">
						我们帮助所有儿童获得优质的基础教育。男童和女童享受平等的教育将惠及社会上的所有人。受过教育的儿童长大后会成为更好的思想者、更优秀的公民，也会成为更称职的家长。
					</div>
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
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/sider.js"></script>
<script type="text/javascript" src="js/about.js"></script>
<script type="text/javascript" src="js/aboutf.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>