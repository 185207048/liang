package com.bluesky.cricle.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bluesky.dao.CommentDao;
import com.bluesky.dao.PostDao;

/**
 * Servlet implementation class AddCommentServlet
 */
@WebServlet("/addcomment")
public class AddCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCommentServlet() {
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
		
		int post_id = Integer.parseInt(new String(request.getParameter("post_id").getBytes("UTF-8"), "UTF-8"));
		String content = new String(request.getParameter("content").getBytes("UTF-8"), "UTF-8");
		int user_id = Integer.parseInt(new String(request.getParameter("user_id").getBytes("UTF-8"), "UTF-8"));
		long time = System.currentTimeMillis();
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		boolean flag = new CommentDao().insertComment(post_id, user_id, time, content);
		boolean flag2 = new PostDao().updateCommentCount(post_id, new PostDao().getPostByid(post_id).getPost_comment_num()+1);
		out.print(flag && flag2);
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
