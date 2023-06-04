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
    
    public static User checkUserFromDb(User user) {
		
		User u = new User(-1,"","","");
		try {
			
			//jdbc code 
			Connection con = CP.createC();			
			String sql = "SELECT * FROM users WHERE email = ? AND password = ?;";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			//set the value of parameters
			pstmt.setString(1, user.getUserEmail());
			pstmt.setString(2, user.getUserPassword());
			
			//execute quary
                        
                        ResultSet res = pstmt.executeQuery();
                        
			if (res.next()) {				
                            int id = res.getInt(1);
                            String userEmail   = res.getString(2);
                            String userName = res.getString(3);
                            String userPassword  = res.getString(4);
                            u = new User(id,userName,userEmail,userPassword);
                        }
                        else{
                            System.out.println("Invalid email or password.");
                        }
			
                        res.close();
			pstmt.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		
		return u;
	}

}