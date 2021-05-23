package com.promineo.tech.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlRepository {
	private Connection conn;
	private final String Username = "root";
	private final String Password = "0021";
	
	public Connection getConnection(String dbName) {
		try
		{
			String connString = "jdbc:mysql://localhost:3306/" + dbName;
			if (conn == null || conn.isClosed()) {
				conn = DriverManager.getConnection(connString, Username, Password);
			}
			
			return conn;
		} 
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
			return conn;
		}
	}
}