package org.example.Connexion1ALINF7.Services;

import javafx.collections.ObservableList;
import org.example.Connexion1ALINF7.Entite.Commande;

public interface ICommandeService {
    void ajouterCommande(Commande commande);

    ObservableList<Commande> listeCommande();

    void supprimerCommande(int id);
}
