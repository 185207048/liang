<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.bluesky.dao.*"
	import="com.bluesky.entity.*" 
	import="java.util.List"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>同一片蓝天</title>
	<!-- BOOTSTRAP STYLES-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FONTAWESOME STYLES-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
     <!-- MORRIS CHART STYLES-->
    <link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
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
                        <h5>..................</h5>
                       
                    </div>
                </div>
                 <!-- /. ROW  -->
 <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                             <a href="PlatformAdd.jsp">增加信息</a>
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                            <%
                            int id=Integer.parseInt(session.getAttribute("userid").toString());
                            List<Platform> list = new PlatformDao().getPlatformByAid(id);
                    		if(list!=null){
							%>
								
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <td>视频号</td>
										
											<td>视频标题</td>
											<td>视频介绍</td>
											<td>视频连接</td>
											<td>视频类别</td>
											<td>操作</td>                  
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
									for(Platform platform:list){
										%>
							<tr>
							<td><%=platform.getId() %></td>
							
							
							<td><%=platform.getTitle()%></td>
							
							<td><%=platform.getContext()%></td>
							<td><%=platform.getVideo()%></td>
							<%if(platform.getFlag()==0){
								%>
								<td>女性赋能</td>
							<% }else{ %>
								<td>儿童</td>
							<%} %>
						
							
							<td>
							<a href="PlatformUpdate.jsp?id=<%=platform.getId()%>">修改</a>
						
						<a href="DeletePlatformServlet?id=<%=platform.getId()%>">删除</a>
						</tr>
						
					<%
						}
					%>
                                    </tbody>
                                </table>
                               
                                <%
								}
								%>
                            </div>
                            
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
     <!-- DATA TABLE SCRIPTS -->
    <script src="assets/js/dataTables/jquery.dataTables.js"></script>
    <script src="assets/js/dataTables/dataTables.bootstrap.js"></script>
        <script>
            $(document).ready(function () {
                $('#dataTables-example').dataTable();
            });
    </script>
         <!-- CUSTOM SCRIPTS -->
    <script src="assets/js/custom.js"></script>
</body>
</html>