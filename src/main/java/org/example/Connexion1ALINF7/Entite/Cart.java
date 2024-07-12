package org.example.Connexion1ALINF7.Entite;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static Cart instance;
    private List<CartItem> items;

    private Cart() {
        items = new ArrayList<>();
    }

    public static Cart getInstance() {
        if (instance == null) {
            instance = new Cart();
        }
        return instance;
    }

    public void addItem(Food food) {

        for (CartItem item : items) {
            if (item.getFood().getId() == food.getId()) {
                item.incrementQuantity();
                return;
            }
        }
        // If not, add it as a new item
        items.add(new CartItem(food, 1));
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void clear() {
        items.clear();
    }
}
