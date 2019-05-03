package com.bluesky.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bluesky.dao.UserDao;

@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddUserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset= UTF-8");
		PrintWriter out = response.getWriter();

		String username = new String(request.getParameter("username").getBytes("UTF-8"), "UTF-8");
		String password = new String(request.getParameter("password").getBytes("UTF-8"), "UTF-8");
		String name = new String(request.getParameter("name").getBytes("UTF-8"), "UTF-8");
		String sex = new String(request.getParameter("sex").getBytes("UTF-8"), "UTF-8");
		String age = new String(request.getParameter("age").getBytes("UTF-8"), "UTF-8");
		String tel = new String(request.getParameter("tel").getBytes("UTF-8"), "UTF-8");
		String adress = new String(request.getParameter("adress").getBytes("UTF-8"), "UTF-8");
		int type = Integer.parseInt(new String(request.getParameter("type").getBytes("UTF-8"), "UTF-8"));
		int money = Integer.parseInt(new String(request.getParameter("money").getBytes("UTF-8"), "UTF-8"));
		int project = Integer.parseInt(new String(request.getParameter("project").getBytes("UTF-8"), "UTF-8"));

		if (new UserDao().checkUserName(username)) {
			out.print(new UserDao().insertUser(username, password, name, sex, age, tel, adress, type,money,project));

		} else
			out.print("repeat"); // ÖØÃû
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
