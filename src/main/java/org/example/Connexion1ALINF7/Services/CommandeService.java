package org.example.Connexion1ALINF7.Services;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.Connexion1ALINF7.Entite.Cart;
import org.example.Connexion1ALINF7.Entite.CartItem;
import org.example.Connexion1ALINF7.Entite.Commande;
import org.example.Connexion1ALINF7.Utils.DataSource;

import java.sql.*;

public class CommandeService implements ICommandeService {

    Connection connection;

    public CommandeService() {
        this.connection = DataSource.getInstance().getCon();
    }

    public static Timestamp timestampFromDate(Date date) {
        return new Timestamp(date.getTime());
    }

    @Override
    public ObservableList<Commande> listeCommande() {
        ObservableList<Commande> commandes =
                FXCollections.observableArrayList();
        String req = "select * from commande";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(req);
            while (resultSet.next()) {
                Commande commande = fromResultSet(resultSet);
                commandes.add(commande);
            }
            resultSet.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return commandes;
    }

    @Override
    public void supprimerCommande(int id) {
        String req = "DELETE FROM commande WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(req)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void ajouterCommande(Commande commande) {
        String req =
                "INSERT INTO commande ( userid, total, comment, sauces, card_number, card_type, payment_type) values ( ?, ?, ?, ?, ?,?,?)";
        var foodItems = Cart.getInstance().getItems();
        try (PreparedStatement statement = connection.prepareStatement(req, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, commande.getUserid());
            statement.setInt(2, commande.getTotal());
            statement.setString(3, commande.getComment());
            statement.setString(4, commande.getSauces());
            statement.setString(5, commande.getCardNumber());
            statement.setString(6, commande.getCardType());
            statement.setString(7, commande.getPaymentType());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    long id = generatedKeys.getLong(1);
                    for (CartItem foodItem : foodItems) {
                        String req2 = "INSERT INTO commande_food(commande_id, food_id) values (?, ?)";
                        try (PreparedStatement statement2 = connection.prepareStatement(req2)) {
                            statement2.setLong(1, id);
                            statement2.setInt(2, foodItem.getFood().getId());
                            statement2.executeUpdate();
                        }
                    }

                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private Commande fromResultSet(ResultSet rs) throws SQLException {
        return new Commande(
                rs.getInt("id"),
                rs.getInt("userid"),
                rs.getInt("total"),
                rs.getString("comment"),
                rs.getString("sauces"),
                rs.getString("payment_type"),
                rs.getString("card_type"),
                rs.getString("card_number")
        );
    }
}
