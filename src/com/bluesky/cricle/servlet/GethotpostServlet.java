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
import com.bluesky.entity.Post;

/**
 * Servlet implementation class GethotpostServlet
 */
@WebServlet("/gethotpost")
public class GethotpostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GethotpostServlet() {
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
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		JSONArray result = new JSONArray();
		ArrayList <Post> postlist = new PostDao().getHotPostList();
		for(int i=0;i<postlist.size();i++) {
			JSONObject post = new JSONObject();
			post.put("id", postlist.get(i).getPost_id());
			post.put("circle_id", postlist.get(i).getForum_id());
			post.put("title", postlist.get(i).getPost_title());
			post.put("comment_count", postlist.get(i).getPost_comment_num());
			result.add(post);
		}
		
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
