package org.example.Connexion1ALINF7.controllers;

import org.example.Connexion1ALINF7.Entite.Food;
import org.example.Connexion1ALINF7.Services.FoodService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class FoodListController implements Initializable {

    public Hyperlink redirectToCart;
    @FXML
    private GridPane gridPane;

    private final FoodService foodService = new FoodService();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Food> foods = foodService.getAll();

        int column = 0;
        int row = 0;

        for (Food food : foods) {
            // Create a new food card
            Pane foodCard = createFoodCard(food);

            // Add the food card to the grid pane
            gridPane.add(foodCard, column, row);


            column++;
            if (column == 3) {
                column = 0;
                row++;
            }
        }
    }

    private Pane createFoodCard(Food food) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FoodCard.fxml"));
            Pane foodCard = loader.load();

            FoodCardController foodCardController = loader.getController();

            foodCardController.setFoodData(food);
            foodCardController.setFoodId(food.getId());
            return foodCard;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @FXML
    void redirectToCartClicked(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Cart.fxml"));
            Parent root = fxmlLoader.load();
            gridPane.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    } public void HandleLogoutClicked(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/login.fxml"));
            Parent root = fxmlLoader.load();
            gridPane.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
