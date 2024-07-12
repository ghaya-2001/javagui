package org.example.Connexion1ALINF7.Utils;

import java.sql.Connection;

public class Test {
    public static void main(String[] args) {
        Connection con1=DataSource.getInstance().getCon();

        Connection con2=DataSource.getInstance().getCon();

        System.out.println(con1);
        System.out.println(con2);
    }
}
