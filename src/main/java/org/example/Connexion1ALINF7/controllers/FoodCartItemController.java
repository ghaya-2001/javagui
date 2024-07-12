package org.example.Connexion1ALINF7.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.example.Connexion1ALINF7.Entite.CartItem;

public class FoodCartItemController {
    @FXML
    private ImageView cartFoodImage;

    @FXML
    private Label cartFoodName;

    @FXML
    private Hyperlink cartFoodQuantity;

    @FXML
    private Label cartFoodPrice;

    private CartItem cartItem;

    public void setCartItem(CartItem cartItem) {
        this.cartItem = cartItem;

        String imagePath = "C:/Users/KH365TK/Downloads/Connexion1ALINF7/src/main/resources/" + cartItem.getFood().getImage();
//        Image image = new Image("/"+ String.valueOf(getClass().getResource(cartItem.getFood().getImage())));
//        cartFoodImage.setImage(image);

        cartFoodName.setText(cartItem.getFood().getName());
        cartFoodPrice.setText(String.valueOf(cartItem.getFood().getPrix()));
        cartFoodQuantity.setText(String.valueOf(cartItem.getQuantity()));
    }
    public void addQuantityClicked(){}

    public void returnClicked(ActionEvent actionEvent) {
    }
}
