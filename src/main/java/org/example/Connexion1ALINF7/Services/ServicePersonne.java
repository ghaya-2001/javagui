package org.example.Connexion1ALINF7.Services;

import org.example.Connexion1ALINF7.Entite.Personne;
import org.example.Connexion1ALINF7.Utils.DataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ServicePersonne implements IService<Personne> {

    private Connection con = DataSource.getInstance().getCon();
    private Statement ste;

    public ServicePersonne() {
        try {
            ste = con.createStatement();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void ajouter(Personne personne) throws SQLException {
        String req = "INSERT INTO `personne` (`nom`, `prenom`, `age`) VALUES ('" + personne.getNom() + "','" + personne.getPrenom() + "'," + " '" + personne.getAge() + "');";

        ste.executeUpdate(req);
    }

    @Override
    public void supprimer(Personne personne) throws SQLException {

    }

    @Override
    public void update(Personne personne) throws SQLException {

    }

    @Override
    public List<Personne> readAll() throws SQLException {
        return null;
    }

    @Override
    public Personne findbyId(int id) throws SQLException {
        return null;
    }
}
