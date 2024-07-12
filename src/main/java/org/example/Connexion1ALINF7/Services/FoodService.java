package org.example.Connexion1ALINF7.Services;



import org.example.Connexion1ALINF7.Entite.Food;
import org.example.Connexion1ALINF7.Utils.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FoodService {
    private Connection con= DataSource.getInstance().getCon();
    private Statement ste;

    public List<Food> getAll() {
        List<Food> foods = new ArrayList<>();
        String query = "SELECT * FROM food";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Food food = new Food();
                food.setId(resultSet.getInt("id"));
                food.setName(resultSet.getString("name"));
                food.setPrix(resultSet.getFloat("prix"));
                food.setImage(resultSet.getString("image"));


                foods.add(food);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foods;
    }
    public Food getFoodById(int id) {
        Food food = null;
        String query = "SELECT * FROM food WHERE id = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                food = new Food();
                food.setId(resultSet.getInt("id"));
                food.setName(resultSet.getString("name"));
                food.setPrix(resultSet.getFloat("prix"));
                food.setImage(resultSet.getString("image"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return food;
    }
}
