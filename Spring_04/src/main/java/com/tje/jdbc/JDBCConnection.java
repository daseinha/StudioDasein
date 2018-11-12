package com.tje.jdbc;

import java.sql.*;

public class JDBCConnection {
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(
					"jdbc:apache:commons:dbcp:mvc");
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		return conn;
	}
}






