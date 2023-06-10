package com.example.optproject2final;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

import static com.example.optproject2final.Main.getProgram;

public class MainController implements IObserverItemAddedListener {

    @FXML
    private TableView<Rentable> table;
    @FXML
    private TableColumn<Rentable, String> brandColumn;
    @FXML
    private TableColumn<Rentable, String> modelColumn;
    @FXML
    private TableColumn<Rentable, String> descriptionColumn;
    @FXML
    private TableColumn<Rentable, String> typeColumn;
    @FXML
    private TableColumn<Rentable, String> statusColumn;
    @FXML
    private TextField brandTextField, modelTextField, descriptionTextField, typeTextField;
    @FXML
    private Button addButton, rentButton, returnButton, uitloggenButton;
    @FXML
    private Label usernameLabel, messageLabel;
    private Timeline clearMessageTimeline;

//    ObservableList<Rentable> list = FXCollections.observableArrayList(
//            new ToyotaCar("Toyota", "Camry", "A nice car"),
//            new FordTruck("Ford", "F150", "A nice truck"),
//            new BoschDrill("Bosch", "Impact drill", "A nice drill")
//    );

    public void initialize() {

        getProgram().registerItemAddedListener(this);

        // Set the username label to the username of the logged in user
        getProgram().setCurrentUser(getProgram().findUser(getProgram().getCurrentUser().getUsername()));
        usernameLabel.setText(getProgram().getCurrentUser().getUsername());

        brandColumn.setCellValueFactory(new PropertyValueFactory<Rentable, String>("brand"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<Rentable, String>("model"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Rentable, String>("description"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<Rentable, String>("type"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<Rentable, String>("status"));

        table.setItems((ObservableList<Rentable>) getProgram().getRentals());

        // Add double-click event listener to the TableView
        table.setOnMouseClicked(this::handleItemDoubleClick);
    }

    public void addButtonOnAction() {
        String brand = brandTextField.getText();
        String model = modelTextField.getText();
        String description = descriptionTextField.getText();
        String type = typeTextField.getText();

        if (type.equalsIgnoreCase("Car")) {
            RentalFactory factory = new ToyotaFactory();
            Car car = factory.createCar();
            getProgram().rentals.add(car);
            getProgram().notifyItemAddedListeners("Car added successfully");
//            table.getItems().add(car);
//            showItemAddedNotification();
            clearTextFields();
        } else if (type.equalsIgnoreCase("Truck")) {
            Truck truck = new FordTruck(brand, model, description);
            getProgram().rentals.add(truck);
            getProgram().notifyItemAddedListeners("Truck added successfully");
//            table.getItems().add(truck);
//            showItemAddedNotification();
            clearTextFields();
        } else if (type.equalsIgnoreCase("Drill")) {
            Drill drill = new BoschDrill(brand, model, description);
            getProgram().rentals.add(drill);
            getProgram().notifyItemAddedListeners("Drill added successfully");
//            table.getItems().add(drill);
//            showItemAddedNotification();
            clearTextFields();
        }
    }

    @Override
    public void onItemAdded(String message) {
        showItemAddedNotification(message);
    }

    public void showItemAddedNotification(String message) {
//        messageLabel.setText(message);
//        // Add any other necessary logic to show or animate the notification

        messageLabel.setText(message);

        // Clear any previously running timeline
        if (clearMessageTimeline != null) {
            clearMessageTimeline.stop();
        }

        // Create a timeline to clear the label text after 5 seconds
        clearMessageTimeline = new Timeline(
                new KeyFrame(Duration.seconds(5), event -> {
                    messageLabel.setText(""); // Clear the label text
                })
        );
        clearMessageTimeline.setCycleCount(1); // Run the timeline once
        clearMessageTimeline.play();
    }

//    public void showItemAddedNotification() {
//        messageLabel.setText("You have a new notification!");
//        // Add any other necessary logic to show or animate the notification
//
//        // Create a timeline to clear the label text after 5 seconds
//        Timeline timeline = new Timeline(
//                new KeyFrame(Duration.seconds(5), event -> {
//                    messageLabel.setText(""); // Clear the label text
//                })
//        );
//        timeline.setCycleCount(1); // Run the timeline once
//        timeline.play(); // Start the timeline
//    }

    public void clearTextFields() {
        this.brandTextField.clear();
        this.modelTextField.clear();
        this.descriptionTextField.clear();
        this.typeTextField.clear();
    }

    public void rentButtonOnAction() {
        Rentable rentable = table.getSelectionModel().getSelectedItem();
        if (rentable != null) {
            rentable.rent();
            table.refresh();
        }
    }

    public void returnButtonOnAction() {
        Rentable rentable = table.getSelectionModel().getSelectedItem();
        if (rentable != null) {
            rentable.returnItem();
            table.refresh();
        }
    }

    public void uitloggenButtonOnAction() {
        getProgram().setCurrentUser(null);
        getProgram().setPrimaryStage((Stage) uitloggenButton.getScene().getWindow());
        getProgram().switchScreen(Screens.LOGIN);
//        getProgram().getPrimaryStage().close();
    }

    public void handleItemDoubleClick(MouseEvent event) {
        if (event.getClickCount() == 2) {
            Rentable rentable = table.getSelectionModel().getSelectedItem();
            if (rentable != null) {
                // Create a new Stage for the pop-up window
                Stage popupStage = new Stage();
                popupStage.setTitle("Item Details");

                // Create a VBox as the root container for the pop-up window
                VBox root = new VBox();
                root.setPadding(new Insets(10));

                // Create and configure UI controls for item information
                Label brandLabel = new Label("Brand: " + rentable.getBrand());
                Label modelLabel = new Label("Model: " + rentable.getModel());
                Label descriptionLabel = new Label("Description: " + rentable.getDescription());
                Label typeLabel = new Label("Type: " + rentable.getType());
                Label statusLabel = new Label("Rented out: " + rentable.getIsRented());

                // Add UI controls to the root container
                root.getChildren().addAll(brandLabel, modelLabel, descriptionLabel, typeLabel, statusLabel);

                // Create a new Scene with the root container
                Scene popupScene = new Scene(root);

                // Set the scene for the pop-up window
                popupStage.setScene(popupScene);

//                // Set the width and height of the pop-up window
//                popupStage.setWidth(200); // Set your desired width
//                popupStage.setHeight(150); // Set your desired height

                // Show the pop-up window
                popupStage.show();
            }
        }
    }
}
