package com.library.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	static Connection connection;
	static String dburl;
	static String username;
	static String password;
	
	public static Connection creteDbConnection() {
		
		dburl="jdbc:postgresql://localhost:5432/library-management";
		username="postgres";
		password="2000";
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			connection = DriverManager.getConnection(dburl,username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}
