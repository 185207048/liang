package com.bluesky.cricle.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bluesky.dao.ForumDao;
import com.bluesky.dao.PostDao;
import com.bluesky.dao.UserDao;
import com.bluesky.entity.Forum;
import com.bluesky.entity.Post;
import com.bluesky.entity.User;

/**
 * Servlet implementation class GetForumListServlet
 */
@WebServlet("/getForumList")
public class GetForumListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetForumListServlet() {
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
		
		JSONArray result = new JSONArray();
		ArrayList<Forum> forumlist = new ForumDao().getAllForum();
		for(int i=0;i<forumlist.size();i++) {
			JSONObject dict = new JSONObject();
			Post post = new PostDao().getPostByCom_num(forumlist.get(i).getForum_id());
			User user = new UserDao().getUserById(post.getUser_id());
			
			dict.put("circle_id", forumlist.get(i).getForum_id());
			dict.put("circle_name", forumlist.get(i).getForum_name());
			dict.put("circle_logo", forumlist.get(i).getForum_icon());
			dict.put("id", post.getPost_id());
			dict.put("title", post.getPost_title());
			dict.put("images", post.getPost_img());
			dict.put("text", post.getPost_text());
			dict.put("user_id", post.getUser_id());
			dict.put("user_nickname", user.getName());
			dict.put("comment_count", post.getPost_comment_num());
			dict.put("created_at", post.getPost_create_time());
			result.add(dict);
		}
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
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
