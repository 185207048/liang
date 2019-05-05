package com.bluesky.cricle.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.bluesky.dao.ActivityDao;
import com.bluesky.dao.ForumDao;
import com.bluesky.dao.UserDao;
import com.bluesky.entity.Forum;
import com.bluesky.entity.User;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class GetForumbyidServlet
 */
@WebServlet("/getForumbyid")
public class GetForumbyidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetForumbyidServlet() {
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
		
		JSONObject result = new JSONObject();
		Forum forum = new ForumDao().getForumById(circle_id);
		User user = new UserDao().getUserById(forum.getUser_id());
		JSONObject userjson = new JSONObject();
		userjson.put("id", user.getId());
		userjson.put("uid", user.getUsername());
		userjson.put("nickname", user.getName());
		userjson.put("photo", "");
		
		result.put("description", forum.getForum_des());
		result.put("icon", forum.getForum_icon());
		result.put("name", forum.getForum_name());
		result.put("adminUserInfo", userjson);
		
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
