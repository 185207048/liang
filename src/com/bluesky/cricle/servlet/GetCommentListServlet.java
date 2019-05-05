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
import com.bluesky.dao.CommentDao;
import com.bluesky.dao.PostDao;
import com.bluesky.dao.UserDao;
import com.bluesky.entity.Comment;
import com.bluesky.entity.User;

/**
 * Servlet implementation class GetCommentListServlet
 */
@WebServlet("/getcommentList")
public class GetCommentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCommentListServlet() {
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
		int page = Integer.parseInt(new String(request.getParameter("page").getBytes("UTF-8"), "UTF-8"));
		int pagesize = Integer.parseInt(new String(request.getParameter("pagesize").getBytes("UTF-8"), "UTF-8"));
		int only_owner = Integer.parseInt(new String(request.getParameter("only_owner").getBytes("UTF-8"), "UTF-8"));
		
		JSONObject result = new JSONObject();
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		int count = new CommentDao().getCommentCount(post_id);
		int adminuserid = new PostDao().getPostByid(post_id).getUser_id();
		result.put("totalPage", count/pagesize+1);
		JSONArray jcommentlist = new JSONArray();
		ArrayList <Comment> commentlist = new CommentDao().getCommentList(only_owner, post_id, adminuserid);
		for(int i=0;i<commentlist.size();i++) {
			Comment comment = new Comment();
			JSONObject jcomment = new JSONObject();
			User user = new UserDao().getUserById(commentlist.get(i).getUser_id());
			jcomment.put("id", commentlist.get(i).getComment_id());
			jcomment.put("content", commentlist.get(i).getComment_content());
			jcomment.put("position", i+1);
			jcomment.put("is_owner", commentlist.get(i).getUser_id()==adminuserid?true:false);
			jcomment.put("is_post_by_admin", commentlist.get(i).getUser_id()==adminuserid?true:false);
			jcomment.put("user_id", commentlist.get(i).getUser_id());
			jcomment.put("user_nickname",user.getName());
			jcomment.put("user_photo", "");
			jcomment.put("user_introduce", "");
			jcomment.put("like_num", commentlist.get(i).getComment_like_num());
			jcomment.put("created_at", commentlist.get(i).getComment_time());
			jcommentlist.add(jcomment);
		}
		result.put("list", jcommentlist);
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
