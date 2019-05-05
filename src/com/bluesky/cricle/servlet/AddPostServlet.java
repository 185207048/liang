package com.bluesky.cricle.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bluesky.dao.PostDao;

/**
 * Servlet implementation class AddPostServlet
 */
@WebServlet("/addpost")
public class AddPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");

		int circle_id = Integer.parseInt(new String(request.getParameter("circle_id").getBytes("UTF-8"), "UTF-8"));
		String tag = new String(request.getParameter("tag").getBytes("UTF-8"), "UTF-8");
		String content = new String(request.getParameter("content").getBytes("UTF-8"), "UTF-8");
		String title = new String(request.getParameter("title").getBytes("UTF-8"), "UTF-8");
		int type = Integer.parseInt(new String(request.getParameter("type").getBytes("UTF-8"), "UTF-8"));
		long time = System.currentTimeMillis();
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
//		System.out.println((int)request.getSession().getAttribute("userid"));
		out.print(new PostDao().insertPost(1,circle_id, tag, content, title, time, type));
		out.flush();
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
	}

}
