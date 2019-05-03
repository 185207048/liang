package com.bluesky.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.bluesky.entity.User;
import com.bluesky.util.DBUtil;

public class UserDao {
	DBUtil util = new DBUtil();

	public boolean insertUser(String username, String password, String name, String sex, String age, String tel,
			String adress, int type, int money, int project) {
		String sql = "insert into bluesky.user(username,password,name,sex,age,tel,adress,type,money,project) values(?,?,?,?,?,?,?,?,?,?)";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, name);
			pstmt.setString(4, sex);
			pstmt.setString(5, age);
			pstmt.setString(6, tel);
			pstmt.setString(7, adress);
			pstmt.setInt(8, type);
			pstmt.setInt(9, money);
			pstmt.setInt(10, project);
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

	public boolean insertUser(String username, String password, String name, String sex, String age, String tel,
			String adress, int type) {
		String sql = "insert into bluesky.user(username,password,name,sex,age,tel,adress,type,money,project) values(?,?,?,?,?,?,?,?,?,?)";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, name);
			pstmt.setString(4, sex);
			pstmt.setString(5, age);
			pstmt.setString(6, tel);
			pstmt.setString(7, adress);
			pstmt.setInt(8, type);
			pstmt.setInt(9, 0);
			pstmt.setInt(10, 0);
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

	// ��¼���
	public int checkUser(String username, String password) {
		String sql = "select * from bluesky.user where username=? and password=?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			int type = -1;
			while (rs.next()) {
				type = rs.getInt(9);
			}
			conn.close();
			return type;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// �޸��û�
	public boolean changeUser(String username, String password, String name, String sex, String age, String tel,
			String adress, int type, int money, int project) {
		String sql = "update bluesky.user set password=? ,name=?,sex=?,age=?,tel=?,adress=?,type=?,money=?,project=? where username=?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, name);
			pstmt.setString(3, sex);
			pstmt.setString(4, age);
			pstmt.setString(5, tel);
			pstmt.setString(6, adress);
			pstmt.setInt(7, type);
			pstmt.setInt(8, money);
			pstmt.setInt(9, project);
			pstmt.setString(10, username);
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

	// ɾ���û�
	public boolean deleteUser(String username) {
		String sql = "delete from  bluesky.user where username=?";
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

	public boolean checkUserName(String username) {
		String sql = "select * from  bluesky.user where username=?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				conn.close();
				return false;
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public String getNameFromaid(int aid) {
		String sql = "select name from bluesky.user where id=?";
		Connection conn = util.getConnection();

		try {

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, aid);
			ResultSet rs = pstmt.executeQuery();
			String name = null;
			while (rs.next()) {
				name = rs.getString(1);
			}
			conn.close();
			return name;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int getIdFromNmae(String username) {
		String sql = "select id from bluesky.user where username=?";
		Connection conn = util.getConnection();

		try {

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			int id = 0;
			while (rs.next()) {
				id = rs.getInt(1);
			}
			conn.close();
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public User getUserById(int id) {
		User u = new User();
		String sql = "select * from bluesky.user where id=?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				u.setId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setName(rs.getString(4));
				u.setSex(rs.getString(5));
				u.setAge(rs.getString(6));
				u.setTel(rs.getString(7));
				u.setAdress(rs.getString(8));
				u.setType(rs.getInt(9));
				u.setMoney(rs.getInt(10));
				u.setProject(rs.getInt(11));
			}
			conn.close();
			return u;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<User> getAllCheckTeacher(int start, int end) {
		ArrayList<User> list = new ArrayList<User>();
		String sql = "select * from bluesky.user where type=3 limt ?,?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setName(rs.getString(4));
				u.setSex(rs.getString(5));
				u.setAge(rs.getString(6));
				u.setTel(rs.getString(7));
				u.setAdress(rs.getString(8));
				u.setType(rs.getInt(9));
				u.setMoney(rs.getInt(10));
				u.setProject(rs.getInt(11));
				list.add(u);
			}
			conn.close();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<User> getAllAdmin(int start, int end) {
		ArrayList<User> list = new ArrayList<User>();
		String sql = "select * from bluesky.user where type=2 limt ?,?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setName(rs.getString(4));
				u.setSex(rs.getString(5));
				u.setAge(rs.getString(6));
				u.setTel(rs.getString(7));
				u.setAdress(rs.getString(8));
				u.setType(rs.getInt(9));
				u.setMoney(rs.getInt(10));
				u.setProject(rs.getInt(11));
				list.add(u);
			}
			conn.close();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<User> getAllUser(int start, int end) {
		ArrayList<User> list = new ArrayList<User>();
		String sql = "select * from bluesky.user where type=0 limt ?,?";
		Connection conn = util.getConnection();
		try {

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setName(rs.getString(4));
				u.setSex(rs.getString(5));
				u.setAge(rs.getString(6));
				u.setTel(rs.getString(7));
				u.setAdress(rs.getString(8));
				u.setType(rs.getInt(9));
				u.setMoney(rs.getInt(10));
				u.setProject(rs.getInt(11));
				list.add(u);
			}
			conn.close();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<User> getAllTeacher(int start, int end) {
		ArrayList<User> list = new ArrayList<User>();
		String sql = "select * from bluesky.user where type=1 limt ?,?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setName(rs.getString(4));
				u.setSex(rs.getString(5));
				u.setAge(rs.getString(6));
				u.setTel(rs.getString(7));
				u.setAdress(rs.getString(8));
				u.setType(rs.getInt(9));
				u.setMoney(rs.getInt(10));
				u.setProject(rs.getInt(11));
				list.add(u);
			}
			conn.close();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<User> getAllUserByType(int type, int start, int end) {
		ArrayList<User> list = new ArrayList<User>();
		String sql = "select * from bluesky.user where type=? limit ?,?";
		Connection conn = util.getConnection();
		try {

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, type);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setName(rs.getString(4));
				u.setSex(rs.getString(5));
				u.setAge(rs.getString(6));
				u.setTel(rs.getString(7));
				u.setAdress(rs.getString(8));
				u.setType(rs.getInt(9));
				u.setMoney(rs.getInt(10));
				u.setProject(rs.getInt(11));
				list.add(u);
			}
			conn.close();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
