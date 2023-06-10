package com.example.optproject2final;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Duration;

import static com.example.optproject2final.Main.getProgram;

public class MainController implements ItemAddedListener {

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
}
