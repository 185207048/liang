package com.bluesky.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bluesky.dao.ActivityDao;
import net.sf.json.JSONArray;

@WebServlet("/GetActivityServlet")
public class GetActivityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetActivityServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		int start = Integer.parseInt(new String(request.getParameter("start").getBytes("UTF-8"), "UTF-8"));
		int end = Integer.parseInt(new String(request.getParameter("end").getBytes("UTF-8"), "UTF-8"));
		
		JSONArray ja = JSONArray.fromObject(new ActivityDao().getAllActivitys(start, end));
		out.print(ja);
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
