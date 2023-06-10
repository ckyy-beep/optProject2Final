package com.example.optproject2final;

public abstract class Gebruiker {
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

    public void showInformation() {
        showCommonInformation();
        showSpecificInformation();
    }

    public void showCommonInformation() {
        System.out.println("Username: " + userName);
        System.out.println("Password: " + password);
    }

    public abstract void showSpecificInformation();

    public abstract String getRole();
}
