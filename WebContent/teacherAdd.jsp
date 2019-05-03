<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="com.bluesky.dao.*"
	import="com.bluesky.entity.*"
	import="com.bluesky.servlet.*"
	import="com.bluesky.until.*"
	import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>同一片蓝天</title>
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
<%
	int aid=Integer.parseInt(session.getAttribute("userid").toString());
	
	String user=new UserDao().getNameFromaid(aid);
	
	%>
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
            <div class="sidebar-collapse">
               <ul class="nav" id="main-menu">
				<li class="text-center">
                    <img src="assets/img/find_user.png" class="user-image img-responsive"/>
					</li>
				
					
                  <li>
                        <a  href="userUpdate.jsp"><i class="fa fa-dashboard fa-3x"></i> 用户管理</a>
                    </li>
                     <li>
                        <a  href="TeacherApply.jsp"><i class="fa fa-desktop fa-3x"></i> 魔豆讲师</a>
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
                     <h2>用户信息</h2>   
                        <h5>增加用户信息</h5>
                       
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
                                    <h3>增加信息</h3>
                                    <form action="AddTeacherServlet" method=post>  
                                        <div class="form-group">
                                            <label>申请人</label>
                                            <input class="form-control" type="hidden" name="aid" value="<%=aid%>" />
                                            <input class="form-control" value="<%=user%>" readonly="true" />
                                        </div>
                                        <div class="form-group">
                                            <label>项目名称</label>
                                            <input class="form-control" name="project"  />
                                        </div>
                                        <div class="form-group">
                                            <label>组织名称</label>
                                            <input class="form-control" name="organizename"  />
                                        </div>
                                        <div class="form-group">
                                            <label>活动地点</label>
                                            <input class="form-control" name="place"  />
                                        </div>
                                        <div class="form-group">
                                            <label>所在学校</label>
                                            <input class="form-control" name="school"  />
                                        </div>
                                        <div class="form-group">
                                            <label>学历</label>
                                            <input class="form-control" name="edu"  />
                                        </div>
                                        <div class="form-group">
                                            <label>专业</label>
                                            <input class="form-control" name="major"  />
                                        </div>
                                        <div class="form-group" hidden="hidden">                                    
                                            <input class="form-control" name="flag" value=0 />
                                        </div>
                                        <input type="hidden" name="method" value="insert">
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
</html>