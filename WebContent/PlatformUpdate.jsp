<%@page import="com.bluesky.entity.Platform"%>
<%@page import="com.bluesky.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="com.bluesky.dao.*"
    import="java.util.List"
    import="java.io.*"
    import="com.bcuserver.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>同视频修改片蓝天系统</title>
	<!-- BOOTSTRAP STYLES-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FONTAWESOME STYLES-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
    <link href="assets/css/custom.css" rel="stylesheet" />
     <!-- GOOGLE FONTS-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body>
	<div id="wrapper">
		<nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">同一片蓝天</a> 
            </div>
  <div style="color: white;
padding: 15px 50px 5px 50px;
float: right;
font-size: 16px;">  &nbsp; <a href="login.jsp" class="btn btn-danger square-btn-adjust">注销</a> </div>
        </nav> 
 <!-- /. NAV TOP  -->
 <nav class="navbar-default navbar-side" role="navigation">
 <%
                       
 		int id=Integer.parseInt(request.getParameter("id"));
 		Platform platform = new PlatformDao().getPlatformById(id);
 		String user=new UserDao().getNameFromaid(Integer.parseInt(platform.getPublisher()));
 		System.out.println("name:"+user);
 		%>
            <div class="sidebar-collapse">
                 <ul class="nav" id="main-menu">
				<li class="text-center">
                    <img src="assets/img/find_user.png" class="user-image img-responsive"/>
					</li>
                     <li>
                        <a  href="userUpdate1.jsp"><i class="fa fa-dashboard fa-3x"></i> 用户管理</a>
                    </li>
                     <li>
                        <a  href="Platform.jsp"><i class="fa fa-desktop fa-3x"></i> 魔豆讲堂</a>
                    </li>
					<li  >
                        <a href="Activity.jsp"><i class="fa fa-bar-chart-o fa-3x"></i> 资助项目</a>
                    </li>					
                </ul>
               
            </div>
            
        </nav>  
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                     <h2>视频信息</h2>   
                        <h5>修改视频信息</h5>
                       
                    </div>
                </div>
                 <!-- /. ROW  -->
 <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                        </div>
                        
                        <div class="panel-body">
                           <div class="row">
                                <div class="col-md-6">
                                    <h3>修改信息</h3>
                                     <form action="UploadChangeActivityServlet"   method=post enctype="multipart/form-data">  
                                     <div class="form-group">
                                            
                                            <input class="form-control" name="id"  type="hidden"value="<%=platform.getId() %>" readOnly="true"/>
                                     
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>视频标题</label>
                                            <input class="form-control" name="title" required="required" value="<%=platform.getTitle()%>"/>
                       
                                        </div>
                                        <div class="form-group">
                                            <label>视频作者</label>
                                            <input class="form-control" required="required" readOnly="true" value="<%=user%>"/>
                                            <input class="form-control"  required="required" type="hidden" value="<%=platform.getPublisher()%>"/>
                                           
                                            <%System.out.println(platform.getContext()); %>
                                        </div>
                                        <div class="form-group">
                                        <label>视频介绍</label>
                                            <input class="form-control" name="context" required="required"  value="<%=platform.getContext()%>"/>
                                            
                                        </div>
                                       	
                                        
                                       <div class="form-group">
                                            <label>视频连接</label>
                                            <input class="form-control" name="video" required="required" value="<%=platform.getVideo()%>"/>
                                        </div>
                       					<div class="form-group">
                                            <label>视频状态</label>
                                            <%if(platform.getFlag()==0){ %>
                                            	<input class="form-control" required="required" " readOnly="true" value="未审核"/>
                                            	<input class="form-control" required="required"  type="hidden" readOnly="true" value="0"/>
                                            <%}else if(platform.getFlag()==1){ %>
                                            <input class="form-control" required="required"  readOnly="true" value="审核通过"/>
                                            	<input class="form-control" required="required"  type="hidden" readOnly="true" value="1"/>
                                            <%}else{ %>
                                            <input class="form-control" required="required"  readOnly="true" value="审核未通过"/>
                                            	<input class="form-control" required="required"  type="hidden"  readOnly="true" value="2"/>
                                            <%} %>
                                        </div>
                                         <div class="form-group">
                                            <label>视频类型</label>
                                            <%if(platform.getType()==0){ %>
                                            <input class="form-control" required="required" readOnly="true"  value="女性赋值"/>
                                            <%}else{ %>
                                            <input class="form-control" required="required" readOnly="true"  value="儿童"/>
                                            <%} %>
                                            
                                            <input class="" name="type" required="required" type="radio" value="0"checked="checked"/>女性赋值       
                                            <input class="" name="type" required="required" value="1"type="radio" />儿童
                                            
                                        </div>
                                        <div class="form-group">
                                            <label>视频封面</label> <br>
                                            <img alt="" src="<%=platform.getImg()%>">
                                           
                                        	<div><input type="file" required="required" name="img"></div>
                                        </div>
                                         
                                        
                                        <input type="hidden" name="method" value="update">
                                        <button type="submit" class="btn btn-default">提交</button>
                                        <button type="reset" class="btn btn-primary">重置</button>
                                    </form>
                                    
                                    </div><!-- col-md-6 -->
                                    </div><!-- row -->
                        </div>
                    </div>
                    <!--End Advanced Tables -->
                    </div>
                    <!-- row -->
                    </div>
                    <!-- page-inner -->
                    </div>
                    <!-- page-wrapper -->
 
	</div>
		

 <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- JQUERY SCRIPTS -->
    <script src="assets/js/jquery-1.10.2.js"></script>
      <!-- BOOTSTRAP SCRIPTS -->
    <script src="assets/js/bootstrap.min.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="assets/js/jquery.metisMenu.js"></script>
      <!-- CUSTOM SCRIPTS -->
    <script src="assets/js/custom.js"></script>
</body>
<script type="text/javascript">

function checkform(){ 
    if(document.getElementById('name').value.length==0){    
        alert('输入为空！');
        document.getElementById('name').focus();
        return false;
    }
   
}

</script>
</html>