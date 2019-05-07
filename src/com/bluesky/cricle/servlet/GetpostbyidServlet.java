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
import com.bluesky.dao.PostDao;
import com.bluesky.dao.UserDao;
import com.bluesky.entity.Post;
import com.bluesky.entity.User;

/**
 * Servlet implementation class GetpostbyidServlet
 */
@WebServlet("/getpostbyid")
public class GetpostbyidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetpostbyidServlet() {
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
		int tag_id = Integer.parseInt(new String(request.getParameter("tag_id").getBytes("UTF-8"), "UTF-8"));
		int page = Integer.parseInt(new String(request.getParameter("page").getBytes("UTF-8"), "UTF-8"));
		int pagesize = Integer.parseInt(new String(request.getParameter("pagesize").getBytes("UTF-8"), "UTF-8"));
		
		JSONObject result = new JSONObject();
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		int totalPage = new PostDao().getPostCount(circle_id, tag_id)/pagesize+1;
		ArrayList <Post> postlist = new PostDao().getPostListByid(circle_id, tag_id, (page-1)*pagesize, pagesize);
		JSONArray jpostlist = new JSONArray();
		for(int i=0;i<postlist.size();i++) {
			JSONObject jpost = new JSONObject();
			jpost.put("id", postlist.get(i).getPost_id());
			jpost.put("title", postlist.get(i).getPost_title());
			jpost.put("imgages", postlist.get(i).getPost_img());
			jpost.put("text", postlist.get(i).getPost_text());
			jpost.put("is_top", postlist.get(i).getIs_top());
			jpost.put("is_official", postlist.get(i).getIs_official());
			jpost.put("tags", postlist.get(i).getPost_tag());
			
			User user = new UserDao().getUserById(postlist.get(i).getUser_id());
			jpost.put("username", user.getName());
			jpost.put("user_photo", user.getId());
			jpost.put("comment_count", postlist.get(i).getPost_comment_num());
			jpost.put("created_at", postlist.get(i).getPost_create_time());
			jpostlist.add(jpost);
		}
		result.put("totalPage", totalPage);
		result.put("list", jpostlist);
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
