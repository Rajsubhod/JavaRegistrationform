package com.UserLogin;

import java.util.Random;

public class User {
    
    private final int userId;
    private String userName;
    private String userEmail;
    private String userPassword;

    public int getUserId() {
        return userId;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public User(int userId, String userName, String userEmail, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public User(String userName, String userEmail, String userPassword) {
        super();
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        Random random = new Random();
        this.userId = random.nextInt(5000);
    }
    
    public User(String userEmail, String userPassword) {
        super();
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userId = 0;
    }
   
}
