package com.example.optproject2final;

public class Medewerker extends Gebruiker {

    private String role = "Medewerker";

    public String getRole() {
        return role;
    }

    public Medewerker(String userName, String password) {
        super(userName, password);
    }

    @Override
    public void showSpecificInformation() {
        System.out.println("Role: " + role);
    }
}
