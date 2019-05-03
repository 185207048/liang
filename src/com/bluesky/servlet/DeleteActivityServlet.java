package com.bluesky.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bluesky.dao.ActivityDao;
import net.sf.json.JSONArray;

@WebServlet("/DeleteActivityServlet")
public class DeleteActivityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteActivityServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset= UTF-8");
		PrintWriter out = response.getWriter();

		int id = Integer.parseInt(new String(request.getParameter("id").getBytes("UTF-8"), "UTF-8"));
		
		JSONArray ja = JSONArray.fromObject(new ActivityDao().deleteActivity(id));
		HttpSession session = request.getSession();
		int type=Integer.parseInt(session.getAttribute("type").toString());
		if(type==0) {
			response.sendRedirect("Activity.jsp");
		}
		else if(type==1) {
			response.sendRedirect("Activity1.jsp");
		}
		out.print(ja);
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
