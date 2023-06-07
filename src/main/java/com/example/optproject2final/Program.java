package com.example.optproject2final;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Program {
    private Stage primaryStage;
    private Screens currentScreen;
    private Scene scene;
    public List<Rentable> rentals;
    private List<RentableObserver> observers;


    public Program(Stage primaryStage) {
        this.primaryStage = primaryStage;
        rentals = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public void startProgram() {
        this.primaryStage.setTitle("Rent-A-Thing");
        this.primaryStage.show();
        this.switchScreen(Screens.LOGIN);
        this.primaryStage.show();
        MainController mainController = new MainController();
        addObserver(mainController);
    }

    public void switchScreen(Screens screen) {
        this.currentScreen = screen;

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/optproject2final/" + screen.getFileName() + ".fxml"));
            this.scene = new Scene(fxmlLoader.load());
            this.primaryStage.setScene(scene);
        } catch (Exception ex) {
            System.err.println("Could not load screen: " + screen + " or " + screen.getFileName() + ".fxml or " + screen.getFileName() + ".css.");
            ex.printStackTrace();
        }
    }

    // Method to add an observer
    public void addObserver(RentableObserver observer) {
        observers.add(observer);
    }

    // Method to remove an observer
    public void removeObserver(RentableObserver observer) {
        observers.remove(observer);
    }

    // Method to notify observers of changes
    public void notifyObservers() {
        for (RentableObserver observer : observers) {
            observer.updateRentableTable();
        }
    }

    // Inside the methods where rent, return, or item addition occurs
// After the changes have been made, call notifyObservers()

    public void rentItem() {
        // Existing code...

        // After rent operation
        notifyObservers();
    }

    public void returnItem() {
        // Existing code...

        // After return operation
        notifyObservers();
    }

    public void addItem() {
        // Existing code...

        // After adding an item
        notifyObservers();
    }


}
