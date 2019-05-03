package com.bluesky.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bluesky.dao.TeacherDao;

import net.sf.json.JSONArray;

@WebServlet("/AddTeacherServlet")
public class AddTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddTeacherServlet() {
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
		
		int aid = Integer.parseInt(new String(request.getParameter("aid").getBytes("UTF-8"), "UTF-8"));
		String project = new String(request.getParameter("project").getBytes("UTF-8"), "UTF-8");
		String organizename = new String(request.getParameter("organizename").getBytes("UTF-8"), "UTF-8");
		String place = new String(request.getParameter("place").getBytes("UTF-8"), "UTF-8");
		String school = new String(request.getParameter("school").getBytes("UTF-8"), "UTF-8");
		String edu = new String(request.getParameter("edu").getBytes("UTF-8"), "UTF-8");
		String major = new String(request.getParameter("major").getBytes("UTF-8"), "UTF-8");
		int flag = Integer.parseInt(new String(request.getParameter("flag").getBytes("UTF-8"), "UTF-8"));
		
		JSONArray ja = JSONArray.fromObject(new TeacherDao().insertTeacher(aid, project,organizename,place,school,edu,major,flag));
		response.sendRedirect("TeacherApply.jsp");
		out.print(ja);
		out.flush();
		out.close();
	}

}
