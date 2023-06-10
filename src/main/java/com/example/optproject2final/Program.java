package com.example.optproject2final;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


import static com.example.optproject2final.Main.getProgram;

public class Program {
    // Fields
    private Stage primaryStage;
    private Screens currentScreen;
    private Scene scene;
    public ObservableList<Rentable> rentals;
    private List<Gebruiker> users;
    private Gebruiker currentUser;
    private List<ItemAddedListener> itemAddedListeners;


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
    public Gebruiker getCurrentUser() {
        return currentUser;
    }

    public void addUsers(Gebruiker user) {
        users.add(user);
    }

    public void removeUsers(Gebruiker user) {
        users.remove(user);
    }

    public void setUsers(List<Gebruiker> users) {
        this.users = users;
    }

    public List<Gebruiker> getUsers() {
        return users;
    }

    public Program(Stage primaryStage) {
        this.primaryStage = primaryStage;
        rentals = FXCollections.observableArrayList();
        users = new ArrayList<>();
        itemAddedListeners = new ArrayList<>();
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
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/example/optproject2final/" + screen.getFileName() + ".fxml"));
            this.scene = new Scene(fxmlLoader.load());
            this.primaryStage.setScene(scene);
        } catch (Exception ex) {
            System.err.println("Could not load screen: " + screen + " or " + screen.getFileName() + ".fxml or " + screen.getFileName() + ".css.");
            ex.printStackTrace();
        }
    }

    public Gebruiker findUser(String username) {
        for (Gebruiker gebruiker : users) {
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
                getProgram().setCurrentUser(gebruiker);
                return true;
            }
        }
        return false;
    }

    // Method to register an ItemAddedListener
    public void registerItemAddedListener(ItemAddedListener listener) {
        itemAddedListeners.add(listener);
    }

    // Method to notify all registered ItemAddedListeners
    public void notifyItemAddedListeners(String message) {
        for (ItemAddedListener listener : itemAddedListeners) {
            listener.onItemAdded(message);
        }
    }
}
