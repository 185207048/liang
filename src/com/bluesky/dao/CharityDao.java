package com.bluesky.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.bluesky.util.DBUtil;

public class CharityDao {
	DBUtil util = new DBUtil();

	public boolean insertUpload(String title, String info, String video, String filename) {
		String sql = "insert into bluesky.charity (title,info,video,filename) values(?,?,?,?)";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, info);
			pstmt.setString(3, video);
			pstmt.setString(4, filename);
			if (pstmt.executeUpdate() > 0) {
				conn.close();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean getUploadByName(String title) {
		String sql = "select * from bluesky.charity where title=?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				conn.close();
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean changeUpload(String title, String info, String video, String filename) {
		String sql = "update bluesky.charity set info=?,video=?,filename=? where title=?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, info);
			pstmt.setString(2, video);
			pstmt.setString(3, filename);
			pstmt.setString(4, title);
			if (pstmt.executeUpdate() > 0) {
				conn.close();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public String getUploadPathByName(String filename) {
		String sql = "select * from bluesky.charity where filename=?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, filename);
			ResultSet rs = pstmt.executeQuery();
			String video = "";
			while (rs.next()) {
				video = rs.getString(4);
			}
			conn.close();
			return video;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
}
