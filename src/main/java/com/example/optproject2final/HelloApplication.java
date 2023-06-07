package com.example.optproject2final;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class HelloApplication extends Application {
    private static Program program;
    public static Program getProgram() {return program;}
    private int yNextStatusScreen;
    private int xNextStatusScreen;


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

    }

    public static void main(String[] args) {
        launch();
    }
}