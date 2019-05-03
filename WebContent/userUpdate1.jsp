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
 <%
                       
 				int id=Integer.parseInt(session.getAttribute("userid").toString());
                        User user = new UserDao().getUserById(id);%>
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
                     <h2>用户信息</h2>   
                        <h5>修改用户信息</h5>
                       
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
                                     <form action="ChangeUserServlet"   method=GET>  
                                     <div class="form-group">
                                            
                                            <input class="form-control" name="id"  type="hidden"value="<%=user.getId() %>" readOnly="true"/>
                                     
                                        </div>
                                         <div class="form-group">
                                            <label>真实名字</label>
                                            <input class="form-control" name="name" required="required" value="<%=user.getName()%>" />
                                            <p class="help-block">不能修改用户名</p>
                                        </div>
                                        <div class="form-group">
                                            <label>用户名</label>
                                            <input class="form-control" name="username" required="required" value="<%=user.getUsername()%>" readOnly="true"/>
                                           
                                        </div>
                                        <div class="form-group">
                                            <label>用户密码</label>
                                            <input class="form-control" name="password" required="required"  value="<%=user.getPassword()%>"/>
                                        </div>
                                       	<div class="form-group">
                                            <label>用户性别</label>
                                            <input class="form-control"  value="<%=user.getSex()%> "/>
                                            
                                            <input class="" name="sex" required="required" type="radio" value="男 "checked="checked"/>男       
                                            <input class="" name="sex" required="required" value="女 "type="radio" />女
                                            
                                        </div>
                                       <div class="form-group">
                                            <label>用户年龄</label>
                                            <input class="form-control" name="age" required="required" value="<%=user.getAge()%>"/>
                                        </div>
                       					<div class="form-group">
                                            <label>用户电话</label>
                                            <input class="form-control" name="tel" required="required" type="number" maxlength="13"  onkeyup="this.value=this.value.replace(/[0-9]{13}/i)" value="<%=user.getTel()%>"/>
                                        </div>
                                         <div class="form-group">
                                            <label>用户地址</label>
                                            <input class="form-control" required="required" name="adress"  value="<%=user.getAdress()%>"/>
                                        </div>
                                       
                                        <div class="form-group">
                                            <label>用户状态</label>
                                            <%
                                            String s;
                                           	 if(user.getType()==0){
                                           		 %>
                                           		 <input class="form-control" value="用户" readOnly="true" >
                                           		 <input class="form-control" name="type"  value="0" type="hidden" required="required" readOnly="true" >
                                           		 <%
                                           	 }else if(user.getType()==1){
                                           		 %>
                                           		 <input class="form-control"  value="讲师" readOnly="true">
                                           		 <input class="form-control" name="type"  value="1" type="hidden" required="required" readOnly="true" >
                                           		 <% 
                                           	 }else if(user.getType()==2){
                                           		 %>
                                           		 <input class="form-control"  value="管理员" readOnly="true">
                                           		 <input class="form-control" name="type"  value="3" type="hidden" required="required" readOnly="true" >
                                           		 <% 
                                           	 }else if(user.getType()==3){
                                           
                                           		 %>
                                           		 <input class="form-control"  value="用户" readOnly="true">
                                           		 <input class="form-control" name="type"  value="4" type="hidden" required="required" readOnly="true" >
                                           		 <%
                                           	 }
                                            %>
                                            
                                        </div> 
                                         <div class="form-group">
                                            <label>用户已捐钱数</label>
                                            <input class="form-control" name="money"  value="<%=user.getMoney()%>" required="required" readOnly="true"/>
                                        </div>                
                                        <div class="form-group">
                                            <label>用户已捐钱个数</label>
                                            <input class="form-control" name="project"  value="<%=user.getProject() %>" required="required" readOnly="true"/>                   
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