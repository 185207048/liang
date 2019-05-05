package com.bluesky.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bluesky.dao.UserDao;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset= UTF-8");
		PrintWriter out = response.getWriter();

		String username = new String(request.getParameter("username").getBytes("UTF-8"), "UTF-8");
		String password = new String(request.getParameter("password").getBytes("UTF-8"), "UTF-8");
		int type =new UserDao().checkUser(username, password);
		//int aid=0;
		//String name=null;
		if (type != -1) {
//			aid=new UserDao().getIdFromNmae(username);
//			name = new UserDao().getNameFromaid(aid);
			request.getSession().setAttribute("userid", new UserDao().getIdFromNmae(username));
			request.getSession().setAttribute("type", type);
			if(type==0) {
				response.sendRedirect("User.jsp");
			}
			else if(type==1) {
				response.sendRedirect("Teacher.jsp");
			}else if (type == 2)
				response.sendRedirect("");
			
		} else
			request.setAttribute("message", "用户名或密码错误!");
		RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
		try {
			rd.forward(request, response);
			return;
		} catch (Exception e) {
		}
		out.print(type);
		out.flush();
		out.close();
	}

}
