package com.bluesky.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.bluesky.entity.Platform;
import com.bluesky.util.DBUtil;

public class PlatformDao {
	DBUtil util = new DBUtil();

	public boolean insertPlatform(String img, String title,String publisher, String context, String video, int flag, int type) {
		String sql = "insert into bluesky.platform (img,title,publisher,context,video,flag,type) values (?,?,?,?,?,?,?)";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, img);
			pstmt.setString(2, title);
			pstmt.setString(3, publisher);
			pstmt.setString(4, context);
			pstmt.setString(5, video);
			pstmt.setInt(6, flag);
			pstmt.setInt(7, type);
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

	public boolean deletePlatform(int id) {
		String sql = "delete from bluesky.platform where id=?";
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

	public boolean changePlatform(int id, String img, String title, String publisher,String context, String video, int flag, int type) {
		String sql = "update bluesky.platform set img=?,title=?,publisher=?,context=?,video=?,flag=?,type=? where id=?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, img);
			pstmt.setString(2, title);
			pstmt.setString(3, publisher);
			pstmt.setString(4, context);
			pstmt.setString(5, video);
			pstmt.setInt(6, flag);
			pstmt.setInt(7, type);
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
	
	public boolean changeplatform(int id,String title, String context, String video, int type,String img) {
		String sql = "update bluesky.platform set img=?,title=?,context=?,video=?,flag=0,type=? where id=?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, img);
			pstmt.setString(2, title);
			pstmt.setString(3, context);
			pstmt.setString(4, video);
			pstmt.setInt(5, type);
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
	
	public boolean changePlatform(int id, int flag) {
		String sql = "update bluesky.platform set flag=? where id=?";
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

	public ArrayList<Platform> getAllWomenPlatform() {
		ArrayList<Platform> list = new ArrayList<Platform>();
		String sql = "select * from bluesky.platform where type=0 and flag=1";
		Connection conn = util.getConnection();
		try {

			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Platform p = new Platform();
				p.setId(rs.getInt(1));
				p.setImg(rs.getString(2));
				p.setTitle(rs.getString(3));
				p.setPublisher(rs.getString(4));
				p.setContext(rs.getString(5));
				p.setVideo(rs.getString(6));
				p.setFlag(rs.getInt(7));
				p.setType(rs.getInt(8));
				list.add(p);
			}
			conn.close();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Platform> getPlatformByAid(int aid) {
		ArrayList<Platform> list = new ArrayList<Platform>();
		String sql = "select * from bluesky.platform where publisher=?";
		Connection conn = util.getConnection();
		try {

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, aid);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Platform p = new Platform();
				p.setId(rs.getInt(1));
				p.setImg(rs.getString(2));
				p.setTitle(rs.getString(3));
				p.setPublisher(rs.getString(4));
				p.setContext(rs.getString(5));
				p.setVideo(rs.getString(6));
				p.setFlag(rs.getInt(7));
				p.setType(rs.getInt(8));
				list.add(p);
			}
			conn.close();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

	public ArrayList<Platform> getAllChildPlatform() {
		ArrayList<Platform> list = new ArrayList<Platform>();
		String sql = "select * from bluesky.platform where type=1 and flag=1";
		Connection conn = util.getConnection();
		try {

			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Platform p = new Platform();
				p.setId(rs.getInt(1));
				p.setImg(rs.getString(2));
				p.setTitle(rs.getString(3));
				p.setPublisher(rs.getString(4));
				p.setContext(rs.getString(5));
				p.setVideo(rs.getString(6));
				p.setFlag(rs.getInt(7));
				p.setType(rs.getInt(8));
				list.add(p);
			}
			conn.close();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Platform> getAllPlatform(int flag, int type, int start, int end) {
		ArrayList<Platform> list = new ArrayList<Platform>();
		String sql = "select * from bluesky.platform where type=? and flag=? limt ?,?";
		Connection conn = util.getConnection();
		try {

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, flag);
			pstmt.setInt(2, type);
			pstmt.setInt(3, start);
			pstmt.setInt(4, end);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Platform p = new Platform();
				p.setId(rs.getInt(1));
				p.setImg(rs.getString(2));
				p.setTitle(rs.getString(3));
				p.setPublisher(rs.getString(4));
				p.setContext(rs.getString(5));
				p.setVideo(rs.getString(6));
				p.setFlag(rs.getInt(7));
				p.setType(rs.getInt(8));
				list.add(p);
			}
			conn.close();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean checkPlatform(int id, int flag) {
		String sql = "update bluesky.platform set flag=? where id=?";
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

	public int getFlag(int id) {
		String sql = "select flag from bluesky.platform where id=?";
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

	public Platform getPlatformById(int id) {
		Platform p = new Platform();
		String sql = "select * from bluesky.platform where id=?";
		System.out.println(id);
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				p.setId(rs.getInt(1));
				p.setImg(rs.getString(2));
				p.setTitle(rs.getString(3));
				p.setPublisher(rs.getString(4));
				p.setContext(rs.getString(5));
				p.setVideo(rs.getString(6));
				p.setFlag(rs.getInt(7));
				p.setType(rs.getInt(8));
			}
			conn.close();
			return p;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
