package com.bluesky.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.bluesky.entity.Teacher;
import com.bluesky.util.DBUtil;

public class TeacherDao {
	DBUtil util = new DBUtil();

	public boolean insertTeacher(int aid, String project, String organizename, String place, String school, String edu,
			String major, int flag) {
		String sql = "insert into bluesky.teacher(aid,project,organizename,place,school,edu,major,flag) values(?,?,?,?,?,?,?,?)";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, aid);
			pstmt.setString(2, project);
			pstmt.setString(3, organizename);
			pstmt.setString(4, place);
			pstmt.setString(5, school);
			pstmt.setString(6, edu);
			pstmt.setString(7, major);
			pstmt.setInt(8, flag);
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

	public boolean changeTeacher(int id, String project, String organizename, String place, String school, String edu,
			String major, int flag) {
		String sql = "update bluesky.teacher set project=? ,organizename=?,place=?,school=?,edu=?,major=?,flag=? where id=?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, project);
			pstmt.setString(2, organizename);
			pstmt.setString(3, place);
			pstmt.setString(4, school);
			pstmt.setString(5, edu);
			pstmt.setString(6, major);
			pstmt.setInt(7, flag);
			pstmt.setInt(8, id);
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

	public boolean deleteTeacher(int id) {
		String sql = "delete from  bluesky.teacher where id=?";
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

	public Teacher getTeacherByid(int id) {
		String sql = "select * from bluesky.teacher where id=?";
		Connection conn = util.getConnection();

		try {

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			Teacher t = new Teacher();
			while (rs.next()) {
				t.setId(rs.getInt(1));
				t.setAid(rs.getInt(2));
				t.setProject(rs.getString(3));
				t.setOrganizename(rs.getString(4));
				t.setPlace(rs.getString(5));
				t.setSchool(rs.getString(6));
				t.setEdu(rs.getString(7));
				t.setMajor(rs.getString(8));
				t.setFlag(rs.getInt(9));
			}
			conn.close();
			return t;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Teacher> getTeacherByAid(int aid) {
		ArrayList<Teacher> list = new ArrayList<Teacher>();
		String sql = "select * from bluesky.teacher where aid=?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, aid);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Teacher t = new Teacher();
				t.setId(rs.getInt(1));
				t.setAid(rs.getInt(2));
				t.setProject(rs.getString(3));
				t.setOrganizename(rs.getString(4));
				t.setPlace(rs.getString(5));
				t.setSchool(rs.getString(6));
				t.setEdu(rs.getString(7));
				t.setMajor(rs.getString(8));
				t.setFlag(rs.getInt(9));
				list.add(t);
			}
			conn.close();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Teacher> getAllTeacher(int flag, int start, int end) {
		ArrayList<Teacher> list = new ArrayList<Teacher>();
		String sql = "select * from bluesky.teacher where flag=? limit ?,?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, flag);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Teacher t = new Teacher();
				t.setId(rs.getInt(1));
				t.setAid(rs.getInt(2));
				t.setProject(rs.getString(3));
				t.setOrganizename(rs.getString(4));
				t.setPlace(rs.getString(5));
				t.setSchool(rs.getString(6));
				t.setEdu(rs.getString(7));
				t.setMajor(rs.getString(8));
				t.setFlag(rs.getInt(9));
				list.add(t);
			}
			conn.close();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean changeTeacherFlag(int id,int aid, int flag) {
		if (flag == 1) {
			String sql = "update bluesky.teacher set flag=? where aid=? and id=?";
			String sql1 = "update bluesky.user set type=1 where id=?";
			Connection conn = util.getConnection();
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				PreparedStatement pstmt1 = conn.prepareStatement(sql1);
				pstmt.setInt(1, flag);
				pstmt.setInt(2, aid);
				pstmt.setInt(3, id);
				pstmt1.setInt(1, aid);
				if (pstmt.executeUpdate() > 0 && pstmt1.executeUpdate() > 0) {
					conn.close();
					return true;
				}
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		} else {
			String sql = "update bluesky.teacher set flag=? where id=?";
			Connection conn = util.getConnection();
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, flag);
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
	}
}
