    package com.example.optproject2final;

    import javafx.event.ActionEvent;
    import javafx.fxml.FXML;
    import javafx.scene.control.Button;
    import javafx.scene.control.Label;
    import javafx.scene.control.TextField;
    import javafx.stage.Stage;

    import static com.example.optproject2final.Main.getProgram;

    public class LoginController {
        @FXML
        private Button cancelButton, loginButton;
        @FXML
        private Label loginMessageLabel;
        @FXML
        private TextField usernameTextField;
        @FXML
        private TextField passwordPasswordField;

        public void loginButtonOnAction(ActionEvent e) throws Exception {

            if (usernameTextField.getText().isBlank() && passwordPasswordField.getText().isBlank()) {
                loginMessageLabel.setText("Please enter a username and password");

            } else if (usernameTextField.getText().isBlank()) {
                loginMessageLabel.setText("Please enter a username");

            } else if (passwordPasswordField.getText().isBlank()) {
                loginMessageLabel.setText("Please enter a password");

            } else if (!usernameTextField.getText().isBlank() && !passwordPasswordField.getText().isBlank()) {

                boolean bool = getProgram().validateLogin(usernameTextField.getText(), passwordPasswordField.getText());
                if (bool) {

                    // Switch to the main screen
                    getProgram().switchScreen(Screens.MAIN);

                    // Create a new login window
                    getProgram().createNewLoginWindow();

                } else {
                    loginMessageLabel.setText("Invalid login. Please try again.");
                }
            }
        }

        public void cancelButtonOnAction(ActionEvent e) {
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.close();
        }
    }


