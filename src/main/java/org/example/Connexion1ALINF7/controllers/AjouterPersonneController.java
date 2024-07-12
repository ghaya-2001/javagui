package org.example.Connexion1ALINF7.controllers;
import org.example.Connexion1ALINF7.Entite.Personne;
import org.example.Connexion1ALINF7.Services.ServicePersonne;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class AjouterPersonneController {

    @FXML
    private TextField txtage;

    @FXML
    private TextField txtnom;

    @FXML
    private TextField txtprenom;

    private final ServicePersonne ser=new ServicePersonne();
    @FXML
    void ajouterPersonne(ActionEvent event) {
       String nom=txtnom.getText();
       String prenom=txtprenom.getText();
       int age=Integer.parseInt(txtage.getText());
        Personne p1=new Personne(nom,prenom,age);


        try{
        ser.ajouter(p1);

        Alert alert1=new Alert(Alert.AlertType.CONFIRMATION);

        alert1.setTitle("CONFIRMATION");
        alert1.setContentText("Personne ajouté avec succés");
        alert1.showAndWait();}

        catch (SQLException e){

            Alert alert=new Alert(Alert.AlertType.ERROR);

            alert.setTitle("ERROR");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
}
