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

/**
 * Servlet implementation class LogServlet
 */
@WebServlet("/LogServlet")
public class LogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset= UTF-8");
		PrintWriter out = response.getWriter();

		String username = new String(request.getParameter("username").getBytes("UTF-8"), "UTF-8");
		String password = new String(request.getParameter("password").getBytes("UTF-8"), "UTF-8");
		int type =new UserDao().checkUser(username, password);
		int aid=0;
		String name="";
		if (type != 0) {
			aid=new UserDao().getIdFromNmae(username);
			name = new UserDao().getNameFromaid(aid);
			//request.getSession().setAttribute("userid", aid);
			//response.sendRedirect("zhu.jsp");
			out.print(type+"/"+aid+"/"+name);
		} else
			//request.setAttribute("message", "用户名或密码错误!");
		//RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			out.print(false);
//		try {
//			rd.forward(request, response);
//			return;
//		} catch (Exception e) {
//		}
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
