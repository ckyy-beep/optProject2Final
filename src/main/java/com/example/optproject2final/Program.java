package com.example.optproject2final;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Program {
    // Fields
    private Stage primaryStage;
    private Screens currentScreen;
    private Scene scene;
    public ObservableList<Rentable> rentals;
    private final List<Gebruiker> gebruikers;
    private Gebruiker currentUser;


    // Getters and Setters
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    public void setCurrentScreen(Screens currentScreen) {
        this.currentScreen = currentScreen;
    }
    public void setScene(Scene scene) {
        this.scene = scene;
    }
    public void addGebruikers(Gebruiker gebruiker) {this.gebruikers.add(gebruiker);}
    public void setCurrentUser(Gebruiker currentUser) {
        this.currentUser = currentUser;
    }
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    public Screens getCurrentScreen() {
        return currentScreen;
    }
    public Scene getScene() {
        return scene;
    }
    public List<Rentable> getRentals() {
        return rentals;
    }
    public List<Gebruiker> getGebruikers() {
        return gebruikers;
    }
    public Gebruiker getCurrentUser() {
        return currentUser;
    }

    public Program(Stage primaryStage) {
        this.primaryStage = primaryStage;
        rentals = FXCollections.observableArrayList();
        gebruikers = new ArrayList<>();
    }

    public void startProgram() {
        this.primaryStage.setTitle("Rent-A-Thing");
        this.primaryStage.show();
        this.switchScreen(Screens.LOGIN);
        this.primaryStage.show();
    }

    public void createNewLoginWindow() {
        this.primaryStage = new Stage();
        this.primaryStage.setTitle("Rent-A-Thing");
        this.primaryStage.show();
        this.switchScreen(Screens.LOGIN);
        this.primaryStage.show();
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

    public Gebruiker findUser(String username) {
        for (Gebruiker gebruiker : gebruikers) {
            if (gebruiker.getUsername().equals(username)) {
                return gebruiker;
            }
        }
        return null;
    }

    public boolean validateLogin(String username, String password) {
        Gebruiker gebruiker = findUser(username);
        if (gebruiker != null) {
            if (gebruiker.getPassword().equals(password)) {
                this.currentUser = gebruiker;
                return true;
            }
        }
        return false;
    }
}
