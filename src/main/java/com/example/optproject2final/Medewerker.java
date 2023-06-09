package com.example.optproject2final;

public class Medewerker extends Gebruiker {

    public Medewerker(String userName, String password) {
        super(userName, password);
    }

    @Override
    public void showSpecificInformation() {
        System.out.println("Medewerker");
    }
}
