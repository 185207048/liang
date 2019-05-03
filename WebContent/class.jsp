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
	<link rel="stylesheet" type="text/css" href="css/class.css">
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
<%
	
	String pages=request.getParameter("pages");
	int i= 16*(Integer.parseInt(pages)-1);
	int p=i+16;
	String details=request.getParameter("details");
	int detail= Integer.parseInt(details);
	
	
	
	
%>
<%
	
	int size=-1;
	
	List<Platform> list;
	//<String> list = new ArrayList<String>();
	if(detail==1){
		list =new PlatformDao().getAllWomenPlatform();
		size =list.size();
		
	}else {
		
		 list =new PlatformDao().getAllChildPlatform();
		 size =list.size();
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
            <li><a href="index.jsp?id">首页</a></li>
            <li><a href="about.jsp">关于魔豆</a></li>
            <li><a href="index_jieshao.jsp">魔豆公益</a></li>
            <li><a href="information_menu.jsp">信息公开</a></li>
            <li><a href="class.jsp?pages=1&details=1">魔豆讲堂</a></li>
            <li><a href="join.jsp">加入魔豆</a></li>
        </ul>
    </div>
    <div class="contain-top-login cen">
        <div class="login"><a class="cor" href="<%=url %>">登陆</a></div>
        <div class="register"><a class="cor" href="register.html">注册</a></div>
    </div>
</div>
<div class="cd-main-content-img">
	<img src="image/class.jpg"/>
</div>
<div class="cd-main-content" id="tab">
		<div class="cd-nav">
			<ul>
				<li><a href="class.jsp?pages=1&details=1", class="tab_btn on">女性赋能</a></li>
		        <li><a href="class.jsp?pages=1&details=0",  class="tab_btn">0-3岁儿童</a></li> 
		    </ul>
	    </div>
	   
		</div>
		<div style="width:100%;">
			<div class="content_activ">
	   	 <%
	   
	    	while(i<p){
	    	
	    		if(i<size){
	    %>
			<div class="contentrow">
				<%if(i<size){%>
				<div class="oneleft po">
				
				<a href="<%=list.get(i).getVideo()%>">
				<div style=" width: 100%;height: 100%;background-image:url('<%=list.get(i).getImg()%>');-moz-background-size:100% 100%;  
    						background-size:100% 100%; ">
				<div class="textlist cor">
				
				
							<%out.println(list.get(i).getTitle()); %><br/>
						<%out.println(list.get(i++).getContext());%>
						
					</div>
					</div>
					</a>
					<% }else{
						i++;
					}%>
				</div>
				
					<%if(i<size){%>
				<div class="oneright">
				<%if(i<size){%>
					<div class="onerighttop po">
					<%if(i<size){%>
					<a href="<%=list.get(i).getVideo()%>">
				<div style=" width: 100%;height: 100%;background-image:url('<%=list.get(i).getImg()%>');-moz-background-size:100% 100%;  
    background-size:100% 100%;">
				<div class="textlist cor">
				
					
							<%out.println(list.get(i).getTitle()); %><br/>
						<%out.println(list.get(i++).getContext());%>
						
					</div>
					</div>
					</a>
					<% }else{
						i++;
					}%>
						
						
					</div>
					<% }else{
						break;
					}%>
					<%if(i<size){%>	
					
					<div class="onerightbottom">
					<%if(i<size){%>
					<a href="<%=list.get(i).getVideo()%>">
						<div class="onerightleft po">
						
					<div style=" width: 100%;height: 100%;background-image:url('<%=list.get(i).getImg()%>');-moz-background-size:100% 100%;  
    background-size:100% 100%;">
						<div class="textlist cor">
						
							
									<%out.println(list.get(i).getTitle()); %><br/>
								<%out.println(list.get(i++).getContext());%>
								
					</div>
					</div>
					</a>
					<% }else{
						i++;
					}%>
						
						
						</div>
						
						<%if(i<size){%>
						<a href="<%=list.get(i).getVideo()%>">
						<div class="onerightright po">
						
				<div  style=" width: 100%;height: 100%;background-image:url('<%=list.get(i).getImg()%>');-moz-background-size:100% 100%;  
    background-size:100% 100%;">
				<div class="textlist cor">
				
					
							<%out.println(list.get(i).getTitle()); %><br/>
						<%out.println(list.get(i++).getContext());%>
						
					</div>
					
					</div>
					</a>
						</div>
					<% }else{
						i++;
					}%>	
					</div>
					<% }else{
						break;
					}%>
				</div>
				<% }else{
						break;
					}%>
			</div>
			
			<% }else{
						break;
					}%>
			<%if(i<size){%>
			<div class="contentrow">
				<%if(i<size){%>
				
				<div class="twoleftone po">
				<a href="<%=list.get(i).getVideo()%>">
				
				<div  style=" width: 100%;height: 100%;background-image:url('<%=list.get(i).getImg()%>');-moz-background-size:100% 100%;  
    				background-size:100% 100%;">
				<div class="textlist cor">
				
					
							<%out.println(list.get(i).getTitle()); %><br/>
						<%out.println(list.get(i++).getContext());%>
						
					</div>
					
					</div>
					</a>
					
				</div>
				
					<% }else{
						i++;
					}%>
				<%if(i<size){%>
					<a href="<%=list.get(i).getVideo()%>">
				<div class="twolefttwo po">
				
				
				<div  style=" width: 100%;height: 100%;background-image:url('<%=list.get(i).getImg()%>');-moz-background-size:100% 100%;  
    background-size:100% 100%;">
				<div class="textlist cor">
			
					
							<%out.println(list.get(i).getTitle()); %><br/>
						<%out.println(list.get(i++).getContext());%>
						
					</div>
					
					</div>
					</a>
					
					
				</div>
				<% }else{
						i++;
					}%>
				<%if(i<size){%>
				<div class="twoleftthree">
				<%if(i<size){%>
					<div class="twoleftthreetop po">
					
					<%if(i<size){%>
					<a href="<%=list.get(i).getVideo()%>">
				<div  style=" width: 100%;height: 100%;background-image:url('<%=list.get(i).getImg()%>');-moz-background-size:100% 100%;  
    background-size:100% 100%;">
				<div class="textlist cor">
					
					
							<%out.println(list.get(i).getTitle()); %><br/>
						<%out.println(list.get(i++).getContext());%>
						
				</div>
					
					</div>
					</a>
					<% }else{
						i++;
					}%>
						
						
					</div>
					<% }else{
						break;
					}%>
					<%if(i<size){%>
					<div class="twoleftthreebottom po">
					<a href="<%=list.get(i).getVideo()%>">
					
					<div  style=" width: 100%;height: 100%;background-image:url('<%=list.get(i).getImg()%>');-moz-background-size:100% 100%;  
    					background-size:100% 100%;">
					<div class="textlist cor">
								<%out.println(list.get(i).getTitle()); %><br/>
							<%out.println(list.get(i++).getContext());%>
							
						</div>
					</div>
					</a>
						
					</div>
					<% }else{
						i++;
					}%>
				</div>
				<% }else{
						break;
					}%>
			</div>
			<%}else{
				break;
			} %>
		<%} %>
		
		
		</div>
		</div>
	    </div>
		<div style="float:right;
	width:50%;">
			<%for(int j=0;j<size/16+1;j++){ %>
			<a href="class.jsp?pages=<%=j+1 %>&details=<%=details%>"><%=j+1 %></a>
		<%} %>
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