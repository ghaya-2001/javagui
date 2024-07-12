package org.example.Connexion1ALINF7.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import org.example.Connexion1ALINF7.Entite.Cart;
import org.example.Connexion1ALINF7.Entite.Food;
import org.example.Connexion1ALINF7.Services.FoodService;

public class FoodCardController {

    @FXML
    private Pane foodCard;

    @FXML
    private ImageView foodImage;

    @FXML
    private Label foodName;

    @FXML
    private Label foodPrice;

    @FXML
    private Button buyButton;

    private FoodService foodService = new FoodService();

    public FoodCardController() {
    }


    public FoodCardController(FoodService foodService) {
        this.foodService = foodService;
    }

    public void setFoodData(Food food) {
        Image image = new Image(getClass().getResource("/"+food.getImage()).toExternalForm());
        foodImage.setImage(image);

        foodName.setText(food.getName());

        foodPrice.setText(String.valueOf(food.getPrix()));
    }
    private int foodId;

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }
    @FXML
    private void handleBuyButtonClicked(ActionEvent event) {
        Food selectedFood = foodService.getFoodById(foodId);
        if (selectedFood != null) {
            Cart.getInstance().addItem(selectedFood);
        }
    }


}