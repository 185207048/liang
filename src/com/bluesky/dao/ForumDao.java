package com.bluesky.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bluesky.entity.Activity;
import com.bluesky.entity.Forum;
import com.bluesky.util.DBUtil;



public class ForumDao {
	DBUtil util = new DBUtil();
	
	public ArrayList<Forum> getAllForum() {
		ArrayList<Forum> list = new ArrayList<Forum>();
		String sql = "select * from bluesky.forum ";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Forum a = new Forum();
				a.setUser_id(rs.getInt(1));
				a.setForum_id(rs.getInt(2));
				a.setForum_icon(rs.getString(3));
				a.setForum_name(rs.getString(4));
				a.setForum_des(rs.getString(5));
				list.add(a);
			}
			conn.close();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Forum getForumById(int id) {
		Forum a = new Forum();
		String sql = "select * from bluesky.forum where forum_id=?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				a.setUser_id(rs.getInt(1));
				a.setForum_id(rs.getInt(2));
				a.setForum_icon(rs.getString(3));
				a.setForum_name(rs.getString(4));
				a.setForum_des(rs.getString(5));
			}
			conn.close();
			return a;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
