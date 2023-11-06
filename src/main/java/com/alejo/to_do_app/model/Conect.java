package com.alejo.to_do_app.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conect {
    private static Connection conect;

    // Constructor privado para evitar instanciación directa
    private Conect () {
    }

    public static Connection getConnection() {
        if (conect == null) {
            try {
                conect = DriverManager.getConnection("jdbc:mysql://localhost:3306/to-do-app?serverTimezone=UTC", "root", "");
                if (conect != null) {
                    System.out.println("Conexión exitosa.");
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return conect;
    }
}
