package com.bluesky.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bluesky.entity.Activity;
import com.bluesky.entity.Post;
import com.bluesky.util.DBUtil;

public class PostDao {
	DBUtil util = new DBUtil();
	
	public Post getPostByCom_num(int forum_id) {
		Post post = new Post();
		String sql = "select * from bluesky.post where forum_id= ? ORDER BY post_comment_num DESC";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, forum_id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
			post.setUser_id(rs.getInt(1));
			post.setPost_id(rs.getInt(2));
			post.setPost_type(rs.getInt(3));
			post.setPost_title(rs.getString(4));
			post.setPost_img(rs.getString(5));
			post.setPost_text(rs.getString(6));
			post.setIs_top(rs.getInt(7));
			post.setIs_official(rs.getInt(8));
			post.setPost_comment_num(rs.getInt(9));
			post.setPost_create_time(rs.getString(10));
			post.setPost_like_num(rs.getInt(11));
			post.setForum_id(rs.getInt(12));
			post.setPost_tag(rs.getString(13));
			}
			conn.close();
			return post;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Post> getPostListByid(int id,int tag_id,int start,int pagesize) {
		ArrayList<Post> list = new ArrayList<Post>();
		String sql = "";
		if(tag_id==0) {
			 sql = "select * from bluesky.post where forum_id = ?  order by is_top desc limit ?,?";
		}else {
			sql = "select * from bluesky.post where forum_id = ? and post_type=? order by is_top desc limit ?,?";
		}
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			if(tag_id==0) {
				pstmt.setInt(1, id);
				pstmt.setInt(2, start);
				pstmt.setInt(3, pagesize);
			}else {
				pstmt.setInt(1, id);
				pstmt.setInt(2, tag_id);
				pstmt.setInt(3, start);
				pstmt.setInt(4, pagesize);
			}
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Post a = new Post();
				a.setUser_id(rs.getInt(1));
				a.setPost_id(rs.getInt(2));
				a.setPost_type(rs.getInt(3));
				a.setPost_title(rs.getString(4));
				a.setPost_img(rs.getString(5));
				a.setPost_text(rs.getString(6));
				a.setIs_top(rs.getInt(7));
				a.setIs_official(rs.getInt(8));
				a.setPost_comment_num(rs.getInt(9));
				a.setPost_create_time(rs.getString(10));
				a.setPost_like_num(rs.getInt(11));
				a.setForum_id(rs.getInt(12));
				a.setPost_tag(rs.getString(13));
				list.add(a);
			}
			conn.close();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int getPostCount(int forum_id,int tag_id) {
		int count = 0;
		String sql = "select COUNT(0) from bluesky.post where forum_id= ? and post_tag=?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, forum_id);
			pstmt.setInt(2, tag_id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			count= rs.getInt(1);
			
			conn.close();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public Post getPostByid(int post_id) {
		Post post = new Post();
		String sql = "select * from bluesky.post where  post_id=?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, post_id);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
			post.setUser_id(rs.getInt(1));
			post.setPost_id(rs.getInt(2));
			post.setPost_type(rs.getInt(3));
			post.setPost_title(rs.getString(4));
			post.setPost_img(rs.getString(5));
			post.setPost_text(rs.getString(6));
			post.setIs_top(rs.getInt(7));
			post.setIs_official(rs.getInt(8));
			post.setPost_comment_num(rs.getInt(9));
			post.setPost_create_time(rs.getString(10));
			post.setPost_like_num(rs.getInt(11));
			post.setForum_id(rs.getInt(12));
			post.setPost_tag(rs.getString(13));
			}
			conn.close();
			return post;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Post> getHotPostList() {
		ArrayList<Post> list = new ArrayList<Post>();
		String sql = "select post_id,forum_id,post_title,post_comment_num from bluesky.post order by post_comment_num DESC";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Post a = new Post();
				a.setPost_id(rs.getInt(1));
				a.setForum_id(rs.getInt(2));
				a.setPost_title(rs.getString(3));
				a.setPost_comment_num(rs.getInt(4));
				
				list.add(a);
			}
			conn.close();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean updateCommentCount(int post_id,int comment_count) {
		String sql = "update bluesky.post set post_comment_num= ? where post_id=?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, comment_count);
			pstmt.setInt(2, post_id);
			
			if (pstmt.executeUpdate() > 0) {
				conn.close();
				return true;
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean insertPost(int user_id,int circle_id,String tag,String content,String title,long time,int type) {
		String sql = "insert into bluesky.post (forum_id,post_tag,post_text,post_title,post_create_time,post_type,user_id) values (?,?,?,?,?,?,?)";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, circle_id);
			pstmt.setString(2, tag);
			pstmt.setString(3, content);
			pstmt.setString(4, title);
			pstmt.setLong(5, time);
			pstmt.setInt(6, type);
			pstmt.setInt(7, user_id);
			
			if (pstmt.executeUpdate() > 0) {
				conn.close();
				return true;
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
