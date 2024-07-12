package org.example.Connexion1ALINF7.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.example.Connexion1ALINF7.Entite.Cart;
import org.example.Connexion1ALINF7.Entite.CartItem;

import java.io.IOException;

public class CartController {
    public Button confirmBuyButton;
    @FXML
    private VBox cartItemsContainer;

    @FXML
    private Label totalPriceLabel;

    private float totalPrice;

    public void initialize() {
        updateCart();
    }

    private void updateCart() {
        cartItemsContainer.getChildren().clear();
        totalPrice = 0;

        for (CartItem item : Cart.getInstance().getItems()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FoodCartItem.fxml"));
            try {
                // Load the root node of the FoodCartItem.fxml
                Pane cartItem = loader.load();

                FoodCartItemController controller = loader.getController();
                controller.setCartItem(item);

                // Add the Pane to the cartItemsContainer
                cartItemsContainer.getChildren().add(cartItem);

                totalPrice += item.getFood().getPrix() * item.getQuantity();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        totalPriceLabel.setText(String.valueOf(totalPrice));
    }


    @FXML
    public void ConfirmButtonClicked(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/supplements.fxml"));
        Parent root = fxmlLoader.load();
        cartItemsContainer.getScene().setRoot(root);
    }

    public void returnClicked(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FoodList.fxml"));
            Parent root = fxmlLoader.load();
            cartItemsContainer.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
