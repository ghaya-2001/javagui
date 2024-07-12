package org.example.Connexion1ALINF7.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.Connexion1ALINF7.Entite.User;
import org.example.Connexion1ALINF7.Services.UserService;

import java.io.IOException;

public class SignUpController {
    @FXML
    private Button cancelButton;

    @FXML
    private TextField enteredFirstname;

    @FXML
    private TextField enteredLastname;

    @FXML
    private PasswordField enteredPassword;

    @FXML
    private TextField enteredUsername;

    @FXML
    private Label signupMessage;

    @FXML
    private Button signupButton;

    private UserService signUpService;

    public SignUpController() {
        signUpService = new UserService();
    }

    @FXML
    void cancelButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void signupButtonOnAction(ActionEvent event) {
        String firstname = enteredFirstname.getText();
        String lastname = enteredLastname.getText();
        String username = enteredUsername.getText();
        String password = enteredPassword.getText();

        User user = new User(firstname,lastname,username,password);

        if (!firstname.isBlank() && !lastname.isBlank() && !username.isBlank() && !password.isBlank()) {
            boolean signedUp = signUpService.signUp(user);
            if (signedUp) {
                signupMessage.setText("Signup Successful!");
            } else {
                signupMessage.setText("Username already exists");
            }
        } else {
            signupMessage.setText("Veuillez remplir tous les champs");
        }
    }

    @FXML
    void redirectToLoginClicked(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/login.fxml"));
            Parent root = fxmlLoader.load();
            enteredFirstname.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
