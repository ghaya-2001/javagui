package org.example.Connexion1ALINF7.Entite;

public class CartItem {
    private Food food;
    private int quantity;

    public CartItem(Food food, int quantity) {
        this.food = food;
        this.quantity = quantity;
    }

    public Food getFood() {
        return food;
    }

    public int getQuantity() {
        return quantity;
    }

    public void incrementQuantity() {
        quantity++;
    }
}
