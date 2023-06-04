package com.UserLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CP {
	
	static Connection con;
	
	public static Connection createC(){
		
		try {
			
			// load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// create connection
			String user = "root";
			String password = "admin";
			String url = "jdbc:mysql://localhost:3306/user";
			con = DriverManager.getConnection(url, user, password);
			
		} 
		catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
		
		return con;
	}
}