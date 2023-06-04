package com.UserLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {

    public static boolean insertUserToDb(User user) {
		
		boolean flag = false;
		
		try {
			
			//jdbc code 
			Connection con = CP.createC();			
			String sql = "INSERT INTO users(id,email, username, password) VALUES(?,?,?,?)";
			
			//PrepareStatement
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			//set the value of parameters
                        pstmt.setInt(1,user.getUserId());
			pstmt.setString(2, user.getUserEmail());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserPassword());
			
			//execute quary
			pstmt.executeUpdate();
			flag = true;
			
			pstmt.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		
		return flag;
	}

}
