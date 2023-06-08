package com.example.optproject2final;

public class Gebruiker {
    private String userName;
    private String password;

    public Gebruiker(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsername() {
        return userName;
    }
    public String getPassword() {
        return password;
    }
}
