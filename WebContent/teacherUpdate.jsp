<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="com.bluesky.dao.*"
	import="com.bluesky.entity.*"
	import="com.bluesky.servlet.*"
	import="com.bluesky.until.*"
	import="java.util.*"
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta htt"src/com/bluesky/servlet/ChangePlatformFlagServlet.java"p-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
                        <a  href="index2.jsp"><i class="fa fa-dashboard fa-3x"></i> 会场管理</a>
                    </li>
                     <li>
                        <a  href="department2.jsp"><i class="fa fa-desktop fa-3x"></i> 部门管理</a>
                    </li>
                    <li>
                        <a class="active-menu"  href="user2.jsp"><i class="fa fa-qrcode fa-3x"></i> 用户管理</a>
                    </li>
						   <li  >
                        <a   href="program2.jsp"><i class="fa fa-bar-chart-o fa-3x"></i> 节目管理</a>
                    </li>	
                     <li>
                        <a href="programtype.jsp"><i class="fa fa-folder fa-3x"></i> 节目类型管理</a>
                    </li>
                      <li  >
                        <a  href="vote.jsp"><i class="fa fa-table fa-3x"></i> 节目评分</a>
                    </li>
                    <li  >
                        <a  href="result.jsp"><i class="fa fa-edit fa-3x"></i> 获奖情况 </a>
                    </li>				
                </ul>
               
            </div>
            
        </nav>  
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                     <h2>学部信息</h2>   
                        <h5>修改学部信息</h5>
                       
                    </div>
                </div>
                 <!-- /. ROW  -->
 <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                        </div>
                        <%int id = Integer.parseInt(request.getParameter("id"));
                        Teacher teacher = new TeacherDao().getTeacherByid(id);     
                    	User user=new UserDao().getUserById(1);
                    	String users=new UserDao().getNameFromaid(id);
               			%>
                        <div class="panel-body">
                           <div class="row">
                             
                                    <h3>修改信息</h3>
                                     <form action="${pageContext.request.contextPath }/ChangeTeacherServlet" method=post>  

                                            <input class="form-control" name="id" value="<%=teacher.getId() %>" type="hidden"/>
                                  
                                        <div class="form-group">
                                            <label>申请人</label>
                                            <input class="form-control" name="aid"  value="<%=teacher.getAid() %>" type="hidden"/>
                                            <input class="form-control" value="<%=user.getName()%>" readOnly="true"/>
                                        </div>
                                        <div class="form-group">
                                            <label>项目名称</label>
                                            <input class="form-control" name="project"  value="<%=teacher.getProject()%>"/>
                                        </div>
                                        <div class="form-group">
                                            <label>组织名称</label>
                                            <input class="form-control" name="organizename"  value="<%=teacher.getOrganizename()%>"/>
                                        </div>
                                        <div class="form-group">
                                            <label>活动地点</label>
                                            <input class="form-control" name="place"  value="<%=teacher.getPlace()%>"/>
                                        </div>
                                        <div class="form-group">
                                            <label>所在学校</label>
                                            <input class="form-control" name="school"  value="<%=teacher.getSchool()%>"/>
                                        </div>
                                        <div class="form-group">
                                            <label>学历</label>
                                            <input class="form-control" name="edu"  value="<%=teacher.getEdu()%>"/>
                                        </div>
                                        <div class="form-group">
                                            <label>专业</label>
                                            <input class="form-control" name="major"  value="<%=teacher.getMajor()%>"/>
                                        </div>
                                            <input class="form-control" name="flag"  value="<%=teacher.getFlag()%>" type="hidden"/>
                                       <%--  <div class="form-group">
                                            <label>部门名称</label>
                                            <select class="form-control" name="dep">
                                            	<option value="<%=user.getUserDep()%>"><%=user.getUserDep()%></option>
                                            	<%
                                            		List<Dep> list=new DepDao().getAllDep();
                                      	  			for(Dep dep:list){
                                      	  				if(dep.getDepName().equals(user.getUserDep()))
                                      	  				{
															continue;
                                      	  				}
                                            	%>
                                            	<option value="<%=dep.getDepName()%>"><%=dep.getDepName()%></option>
                                            	<%} %>
                                            </select>
                                        </div> --%>
                                       <%--  <div class="form-group">
                                            <label>用户类型</label>
                                            <select class="form-control" name="type">
                                            	<%if(teacher.getUserType().equals("管理员")){%>
                                            	<option value="<%=teacher.getUserType%>"><%=user.getUserType%></option>
                                            	<option value="普通用户">普通用户</option>
                                            	<%}else{ %>
                                            	<option value="<%=user.getUserType%>"><%=teacher.getUserType%></option>
                                            	<option value="管理员">管理员</option>
                                            	<%} %></select>
                                        </div> --%>
                                       
                                      <!--   <div class="form-group">
                                            <label>用户状态</label>
                                            <input class="form-control" name="status"  />                   
                                        </div> -->
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
</html>