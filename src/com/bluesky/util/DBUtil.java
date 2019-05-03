package com.bluesky.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(
					"jdbc:mysql://39.105.34.171:3306/bluesky?useUnicode=true&characterEncoding=UTF-8&useSSL=false&autoReconnect=true&failOverReadOnly=false",
					"root", "root");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}