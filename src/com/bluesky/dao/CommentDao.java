package com.bluesky.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bluesky.entity.Comment;
import com.bluesky.entity.Post;
import com.bluesky.util.DBUtil;

public class CommentDao {
	DBUtil util = new DBUtil();
	
	public boolean insertComment(int post_id,int user_id,long time,String comment_content) {
		String sql = "insert into bluesky.comment (post_id,user_id,comment_time,comment_content) values (?,?,?,?)";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, post_id);
			pstmt.setInt(2, user_id);
			pstmt.setLong(3, time);
			pstmt.setString(4, comment_content);
			
			
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
	
	public int getCommentCount(int post_id) {
		int count = 0;
		String sql = "select COUNT(0) from bluesky.comment where post_id= ? ";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, post_id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				count= rs.getInt(1);
			}
			
			conn.close();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public ArrayList<Comment> getCommentList(int only_owner,int post_id,int user_id) {
		ArrayList<Comment> list = new ArrayList<Comment>();
		String sql = "";
		if(only_owner==0)
			sql = "select * from comment where post_id=?";
		else
			sql = "select * from comment where post_id=? and user_id=?";
		
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			if(only_owner==0)
				pstmt.setInt(1, post_id);
			else {
				pstmt.setInt(1, post_id);
				pstmt.setInt(2, user_id);
				}
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Comment a = new Comment();
				a.setComment_id(rs.getInt(1));
				a.setPost_id(rs.getInt(2));
				a.setUser_id(rs.getInt(3));
				a.setComment_time(rs.getLong(4));
				a.setComment_content(rs.getString(5));
				a.setComment_like_num(rs.getInt(6));
				
				list.add(a);
			}
			conn.close();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
