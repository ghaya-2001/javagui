package org.example.Connexion1ALINF7;

import java.sql.*;

public class Test {

    static String url="jdbc:mysql://localhost:3306/gui";
    static String login="root";
    static String pwd="";

    static Connection con;
    static Statement ste;

    public static void main(String[] args) {
        try {
            con=DriverManager.getConnection(url,login,pwd);
            System.out.println("connexion établie");
        } catch (SQLException e) {
            System.out.println(e);
        }

        try {
            ste= con.createStatement();


            ResultSet rs=ste.executeQuery("select * from food");

            while (rs.next()) {
                int id=rs.getInt(1);
                String name=rs.getString(2);
                Float prix=rs.getFloat(3);
                System.out.println("id :"+id+" nom :"+name+" prix :"+prix);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
