package com.alejo.to_do_app.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conection {
    public Connection getConection(){
        Connection conection = null;
        try {
            conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/to-do-app?serverTimezone=UTC","root","");
            if(conection != null){
                System.out.println("Nice!");
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return conection;
    }
}
