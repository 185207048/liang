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

/**
 * Servlet implementation class ChangActivtiyServlet
 */
@WebServlet("/ChangActivtiyServlet")
public class ChangActivtiyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangActivtiyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset= UTF-8");
		PrintWriter out = response.getWriter();

		int id = Integer.parseInt(new String(request.getParameter("id").getBytes("UTF-8"), "UTF-8"));
		String title = new String(request.getParameter("title").getBytes("ISO-8859-1"), "UTF-8");
		String info = new String(request.getParameter("info").getBytes("ISO-8859-1"), "UTF-8");
		String img = new String(request.getParameter("img").getBytes("ISO-8859-1"), "UTF-8");
		JSONArray ja = JSONArray.fromObject(new ActivityDao().changeActivitys(id, title, info, img, 3));
		//response.sendRedirect("user2.jsp");
		out.print(ja);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
