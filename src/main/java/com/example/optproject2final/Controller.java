package com.example.optproject2final;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static com.example.optproject2final.HelloApplication.getProgram;

public class Controller {
    @FXML
    private Button cancelButton, loginButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordPasswordField;

    public void loginButtonOnAction(ActionEvent e) throws Exception {
        boolean bool = validateLogin();
        if (bool) {
            getProgram().switchScreen(Screens.MAIN);

        }
    }

    public void cancelButtonOnAction(ActionEvent e) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public boolean validateLogin() {
        String username = usernameTextField.getText();
        String password = passwordPasswordField.getText();

        String secretUsername = "admin";
        String secretPassword = "admin";

        if (username.isBlank() && password.isBlank()) {
            loginMessageLabel.setText("Please enter username and password.");
            return false;
        }
        else if (secretUsername.equals(username) && secretPassword.equals(password)) {
            loginMessageLabel.setText("Login Successful!");
            return true;
        }
        else {
            loginMessageLabel.setText("Incorrect username or password!");
            return false;
        }
    }

//    public void openMainWindow() throws Exception {
//        Stage primaryStage = new Stage();
//        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
//        primaryStage.setTitle("Main Window");
//        primaryStage.setScene(new Scene(root));
//        primaryStage.show();
//
//        Stage currentStage = (Stage) cancelButton.getScene().getWindow();
//        currentStage.close();
//    }
}


