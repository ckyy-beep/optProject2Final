package com.example.optproject2final;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static Program program;
    public static Program getProgram() {return program;}

    @Override
    public void start(Stage stage) throws IOException {

        program = new Program(stage);
        program.startProgram();

        RentalFactory factory = new ToyotaFactory();
        Car car01 = factory.createCar();
        getProgram().rentals.add(car01);

        RentalFactory factory2 = new FordFactory();
        Truck truck01 = factory2.createTruck();
        getProgram().rentals.add(truck01);

        RentalFactory factory3 = new BoschFactory();
        Drill drill01 = factory3.createDrill();
        getProgram().rentals.add(drill01);

        Gebruiker gebruiker01 = new Medewerker("Jan", "admin");
        Gebruiker gebruiker02 = new Medewerker("Piet", "admin");
        Gebruiker gebruiker03 = new Medewerker("Klaas", "admin");
        Gebruiker gebruiker04 = new Medewerker("Henk", "admin");
        Gebruiker gebruiker05 = new Medewerker("Paul", "admin");
        Gebruiker gebruiker06 = new Medewerker("Pascal", "admin");
        Gebruiker gebruiker07 = new Medewerker("Julius", "admin");
        Gebruiker gebruiker08 = new Medewerker("Chris", "admin");

        getProgram().addUsers(gebruiker01);
        getProgram().addUsers(gebruiker02);
        getProgram().addUsers(gebruiker03);
        getProgram().addUsers(gebruiker04);
        getProgram().addUsers(gebruiker05);
        getProgram().addUsers(gebruiker06);
        getProgram().addUsers(gebruiker07);
        getProgram().addUsers(gebruiker08);

    }

    public static void main(String[] args) {
        launch();
    }
}