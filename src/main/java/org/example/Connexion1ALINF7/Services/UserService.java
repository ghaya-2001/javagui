package org.example.Connexion1ALINF7.Services;


import org.example.Connexion1ALINF7.Entite.User;
import org.example.Connexion1ALINF7.Utils.DataSource;

import java.sql.*;

public class UserService {

    public static User connectedUser;
    private Connection con = DataSource.getInstance().getCon();
    private Statement ste;

    public boolean login(User user) {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) ;
            {
                connectedUser = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("password"),
                        resultSet.getString("profile_pic")
                );
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean signUp(User user) {
        String query = "INSERT INTO users (firstname, lastname, username, password) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, user.getFirstname());
            preparedStatement.setString(2, user.getLastname());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void updatePicture(int userId, String profilePictureUrl) {
        String query = "UPDATE users SET profile_pic = ? WHERE id = ?";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, profilePictureUrl);
            pst.setInt(2, userId);
            pst.executeUpdate();
            System.out.printf("updatePicture: %s \n", profilePictureUrl);
        } catch (SQLException e) {
            System.out.println("Update picture failed");
            throw new RuntimeException(e);
        }
    }

}
