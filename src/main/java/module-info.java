module org.example.jdbc3a3 {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires cloudinary.core;
    requires stripe.java;

    opens org.example.Connexion1ALINF7 to javafx.fxml, javafx.graphics;
    opens org.example.Connexion1ALINF7.controllers to javafx.fxml, javafx.graphics;
    exports org.example.Connexion1ALINF7;
}