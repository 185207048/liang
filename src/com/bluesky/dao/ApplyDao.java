package com.bluesky.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.bluesky.entity.Apply;
import com.bluesky.util.DBUtil;

public class ApplyDao {
	DBUtil util = new DBUtil();

	public boolean insertApply(int pid, String username) {
		String sql = "insert into bluesky.apply (pid,username) values (?,?)";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pid);
			pstmt.setString(2, username);
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

	public boolean deleteApply(int pid) {
		String sql = "delete from bluesky.apply where pid=?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pid);
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

	public boolean deleteApplyByName(String username) {
		String sql = "delete from bluesky.apply where username=?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
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

	public boolean changeApply(int oldpid, int pid, String username) {
		String sql = "update bluesky.apply set pid=?,username=? where pid=?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pid);
			pstmt.setString(2, username);
			pstmt.setInt(3, oldpid);
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

	public ArrayList<Apply> getApplyByPid(int pid) {
		ArrayList<Apply> list = new ArrayList<Apply>();
		String sql = "select * from bluesky.apply where pid=?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pid);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Apply a = new Apply();
				a.setId(rs.getInt(1));
				a.setPid(rs.getInt(2));
				a.setUsername(rs.getString(3));
				a.setPhone(rs.getString(4));
				a.setAdress(rs.getString(5));
				list.add(a);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
