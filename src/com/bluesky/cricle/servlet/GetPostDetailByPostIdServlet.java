package com.bluesky.cricle.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.bluesky.dao.ForumDao;
import com.bluesky.dao.PostDao;
import com.bluesky.dao.UserDao;
import com.bluesky.entity.Forum;
import com.bluesky.entity.Post;
import com.bluesky.entity.User;

/**
 * Servlet implementation class GetPostDetailByPostIdServlet
 */
@WebServlet("/getPostDetailByPostId")
public class GetPostDetailByPostIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPostDetailByPostIdServlet() {
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
		
		JSONObject result = new JSONObject();
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		Post post = new PostDao().getPostByid( post_id);
		User user = new UserDao().getUserById(post.getUser_id());
		Forum forum = new ForumDao().getForumById(post.getForum_id());
		
		result.put("id", post.getPost_id());
		result.put("title", post.getPost_title());
		result.put("content", post.getPost_text());
		result.put("is_top", post.getIs_top());
		result.put("user_id", user.getId());
		result.put("user_nickname", user.getName());
		result.put("user_photo", "");
		result.put("like_count", post.getPost_like_num());
		result.put("is_official", post.getIs_official());
		result.put("is_post_by_admin", forum.getUser_id()==post.getUser_id()?true:false);
		result.put("created_at", post.getPost_create_time());
		
		out.print(result);
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
