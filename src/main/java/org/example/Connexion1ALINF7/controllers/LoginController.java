package org.example.Connexion1ALINF7.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.Connexion1ALINF7.Entite.User;
import org.example.Connexion1ALINF7.Services.UserService;

import java.io.IOException;


public class LoginController {

    private UserService userService;
    @FXML
    private TextField enteredPassword;
    @FXML
    private TextField enteredUsername;
    @FXML
    private Button loginButton;
    @FXML
    private Label loginMessage;
    @FXML
    private Button cancelButton;
    @FXML
    private Hyperlink redirectToSignup;
    public LoginController() {
        userService = new UserService();
    }

    public void loginButtonOnAction(ActionEvent event) {
        String username = enteredUsername.getText();
        String password = enteredPassword.getText();
        User user = new User(username, password);

        if (!username.isBlank() && !password.isBlank()) {
            boolean loggedIn = userService.login(user);
            if (loggedIn) {
//                loginMessage.setText("Login Successful!");
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FoodList.fxml"));
                    Parent root = fxmlLoader.load();
                    enteredUsername.getScene().setRoot(root);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                loginMessage.setText("Invalid username or password!");
            }
        } else {
            loginMessage.setText("Veuillez remplir tous les champs");
        }
    }

    public void validateLogin() {

    }

    public void cancelButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void redirectToSignupClicked(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/SignUp.fxml"));
            Parent root = fxmlLoader.load();
            enteredUsername.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
