package org.example.Connexion1ALINF7.controllers;

import javafx.fxml.FXML;
import org.example.Connexion1ALINF7.Entite.CartItem;

import javax.swing.text.html.ImageView;
import java.awt.*;

public class CartItemController {
    @FXML
    private ImageView cartFoodImage;

    @FXML
    private Label cartFoodName;

    @FXML
    private Label cartFoodQuantity;

    @FXML
    private Label cartFoodPrice;

    private CartItem cartItem;

    public void setCartItem(CartItem cartItem) {
        this.cartItem = cartItem;
        cartFoodName.setText(cartItem.getFood().getName());
        cartFoodPrice.setText(String.valueOf(cartItem.getFood().getPrix()));
        cartFoodQuantity.setText(String.valueOf(cartItem.getQuantity()));
    }
}
