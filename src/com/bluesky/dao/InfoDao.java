package com.bluesky.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.bluesky.entity.Info;
import com.bluesky.util.DBUtil;

public class InfoDao {
	DBUtil util = new DBUtil();

	public boolean insertInfo(String title, String img, String context, int type) {
		String sql = "insert into bluesky.info (title,img,context,type) values (?,?,?,?)";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, img);
			pstmt.setString(3, context);
			pstmt.setInt(4, type);
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

	public boolean deleteInfo(int id) {
		String sql = "delete from bluesky.info where id=?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
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

	public int getid(String title) {
		String sql = "select id from bluesky.info where title=?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			ResultSet rs = pstmt.executeQuery();
			int count = 0;
			while (rs.next()) {
				count = rs.getInt(1);
			}
			conn.close();
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public boolean getUploadByName(String title) {
		String sql = "select * from bluesky.info where title=?";
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

	public boolean changeInfo(int id, String title, String img, String context, int type) {
		String sql = "update bluesky.info set title=?,img=?,context=?,type=? where id=?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, img);
			pstmt.setString(3, context);
			pstmt.setInt(4, type);
			pstmt.setInt(5, id);
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

	public ArrayList<Info> getAllInfo(int type, int start, int end) {
		ArrayList<Info> list = new ArrayList<Info>();
		String sql = "select * from bluesky.info where type=? limit ?,?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, type);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Info i = new Info();
				i.setId(rs.getInt(1));
				i.setTitle(rs.getString(2));
				i.setImg(rs.getString(3));
				i.setContext(rs.getString(4));
				i.setType(rs.getInt(5));
				list.add(i);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
