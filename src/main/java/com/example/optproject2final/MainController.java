package com.example.optproject2final;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import static com.example.optproject2final.HelloApplication.getProgram;

public class MainController {

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
    private Button addButton, rentButton, returnButton;
    @FXML
    private Label usernameLabel;

//    ObservableList<Rentable> list = FXCollections.observableArrayList(
//            new ToyotaCar("Toyota", "Camry", "A nice car"),
//            new FordTruck("Ford", "F150", "A nice truck"),
//            new BoschDrill("Bosch", "Impact drill", "A nice drill")
//    );

    public void initialize() {

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
//            table.getItems().add(car);
            clearTextFields();
        } else if (type.equalsIgnoreCase("Truck")) {
            Truck truck = new FordTruck(brand, model, description);
            getProgram().rentals.add(truck);
//            table.getItems().add(truck);
            clearTextFields();
        } else if (type.equalsIgnoreCase("Drill")) {
            Drill drill = new BoschDrill(brand, model, description);
            getProgram().rentals.add(drill);
//            table.getItems().add(drill);
            clearTextFields();
        }
    }

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
}
