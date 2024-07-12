package org.example.Connexion1ALINF7.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

    private static DataSource data;
    private String url = "jdbc:mysql://localhost:3306/gui";
    private String login = "root";
    private String pwd = "0000";
    private Connection con;

    public DataSource() {

        try {
            con = DriverManager.getConnection(url, login, pwd);
            System.out.println("connexion établie");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static DataSource getInstance() {
        if (data == null)
            data = new DataSource();
        return data;
    }

    public Connection getCon() {
        return con;
    }


}
