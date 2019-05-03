package com.bluesky.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.bluesky.entity.Activity;
import com.bluesky.util.DBUtil;

public class ActivityDao {
	DBUtil util = new DBUtil();

	public boolean insertActivity(int aid,String title, String info, String img, int status, String money) {
		String sql = "insert into bluesky.activity (aid,title,info,img,status,money) values (?,?,?,?,?,?)";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, aid);
			pstmt.setString(2, title);
			pstmt.setString(3, info);
			pstmt.setString(4, img);
			pstmt.setInt(5, status);
			pstmt.setString(6, money);
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

	public boolean deleteActivity(int id) {
		String sql = "delete from bluesky.activity where id=?";
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

	public boolean changeActivitys(int id, String title, String info, String img, int status) {
		String sql = "update bluesky.activity set title=?,info=?,img=?,status=? where id=?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, info);
			pstmt.setString(3, img);
			pstmt.setInt(4, status);
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
	
	public boolean changeActivitys(int id, int aid,String title, String info, String img, int status,String money) {
		String sql = "update bluesky.activity set aid=?,title=?,info=?,img=?,status=?,money=? where id=?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, aid);
			pstmt.setString(2, title);
			pstmt.setString(3, info);
			pstmt.setString(4, img);
			pstmt.setInt(4, status);
			pstmt.setString(5, money);
			pstmt.setInt(6, id);
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
	
	public boolean changeActivity(int id,int status) {
		String sql = "update bluesky.activity set status=? where id=?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, status);
			pstmt.setInt(2, id);
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
	
	public boolean changeActivitys(int id,String title,String info) {
		String sql = "update bluesky.activity set title=?,info=?,status=3 where id=?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, info);
			pstmt.setInt(3, id);
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

	public ArrayList<Activity> getAllActivity(int start, int end) {
		ArrayList<Activity> list = new ArrayList<Activity>();
		String sql = "select * from bluesky.activity limit ?,?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Activity a = new Activity();
				a.setId(rs.getInt(1));
				a.setAid(rs.getInt(2));
				a.setTitle(rs.getString(3));
				a.setInfo(rs.getString(4));
				a.setImg(rs.getString(5));
				a.setStatus(rs.getInt(6));
				a.setMoney(rs.getString(7));
				list.add(a);
			}
			conn.close();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Activity getActivityById(int id) {
		Activity a = new Activity();
		String sql = "select * from bluesky.activity where id=?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				a.setId(rs.getInt(1));
				a.setAid(rs.getInt(2));
				a.setTitle(rs.getString(3));
				a.setInfo(rs.getString(4));
				a.setImg(rs.getString(5));
				a.setStatus(rs.getInt(6));
				a.setMoney(rs.getString(7));
			}
			conn.close();
			return a;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Activity> getAllActivitys(int start, int end) {
		ArrayList<Activity> list = new ArrayList<Activity>();
		String sql = "select * from bluesky.activity limit ?,?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Activity a = new Activity();
				a.setId(rs.getInt(1));
				a.setAid(rs.getInt(2));
				a.setTitle(rs.getString(3));
				a.setInfo(rs.getString(4));
				a.setImg(rs.getString(5));
				a.setStatus(rs.getInt(6));
				a.setMoney(rs.getString(7));
				list.add(a);
			}
			conn.close();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int getCountStatus(int status) {
		String sql = "select count(id) from bluesky.activity where status=?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, status);
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

	public int getStatus(int id) {
		String sql = "select status from bluesky.activity where id=?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
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
		String sql = "select * from bluesky.activity where title=?";
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

	public ArrayList<Activity> getAllCheckingActivity(int start, int end) {
		ArrayList<Activity> list = new ArrayList<Activity>();
		String sql = "select * from bluesky.activity where status=4 limit ?,?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Activity a = new Activity();
				a.setId(rs.getInt(1));
				a.setAid(rs.getInt(2));
				a.setTitle(rs.getString(3));
				a.setInfo(rs.getString(4));
				a.setImg(rs.getString(5));
				a.setStatus(rs.getInt(6));
				a.setMoney(rs.getString(7));
				list.add(a);
			}
			conn.close();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Activity> getAllActivityByStatus(int status,int start, int end) {
		ArrayList<Activity> list = new ArrayList<Activity>();
		String sql = "select * from bluesky.activity where status=? limit ?,?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, status);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Activity a = new Activity();
				a.setId(rs.getInt(1));
				a.setAid(rs.getInt(2));
				a.setTitle(rs.getString(3));
				a.setInfo(rs.getString(4));
				a.setImg(rs.getString(5));
				a.setStatus(rs.getInt(6));
				a.setMoney(rs.getString(7));
				list.add(a);
			}
			conn.close();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Activity> getActivityByAid(int aid) {
		ArrayList<Activity> list = new ArrayList<Activity>();
		String sql = "select * from bluesky.activity where aid=?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, aid);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Activity a = new Activity();
				a.setId(rs.getInt(1));
				a.setAid(rs.getInt(2));
				a.setTitle(rs.getString(3));
				a.setInfo(rs.getString(4));
				a.setImg(rs.getString(5));
				a.setStatus(rs.getInt(6));
				a.setMoney(rs.getString(7));
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
