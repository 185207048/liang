package com.bluesky.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bluesky.dao.UserDao;
import net.sf.json.JSONArray;

@WebServlet("/ChangeUserServlet")
public class ChangeUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ChangeUserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset= UTF-8");
		PrintWriter out = response.getWriter();

		String username = new String(request.getParameter("username").getBytes("ISO-8859-1"), "UTF-8");
		String password = new String(request.getParameter("password").getBytes("UTF-8"), "UTF-8");
		String name = new String(request.getParameter("name").getBytes("UTF-8"), "UTF-8");
		String sex = new String(request.getParameter("sex").getBytes("UTF-8"), "UTF-8");
		String age = new String(request.getParameter("age").getBytes("UTF-8"), "UTF-8");
		String tel = new String(request.getParameter("tel").getBytes("UTF-8"), "UTF-8");
		String adress = new String(request.getParameter("adress").getBytes("UTF-8"), "UTF-8");
		int type = Integer.parseInt(new String(request.getParameter("type").getBytes("UTF-8"), "UTF-8"));
		int money = Integer.parseInt(new String(request.getParameter("money").getBytes("UTF-8"), "UTF-8"));
		int project = Integer.parseInt(new String(request.getParameter("project").getBytes("UTF-8"), "UTF-8"));

		JSONArray ja = JSONArray.fromObject(
				new UserDao().changeUser(username, password, name, sex, age, tel, adress, type, money, project));
		HttpSession session = request.getSession();
		int type1=Integer.parseInt(session.getAttribute("type").toString());
		if(type1==0) {
			response.sendRedirect("userUpdate.jsp");
		}
		else if(type1==1) {
			response.sendRedirect("userUpdate1.jsp");
		}
		out.print(ja);
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
