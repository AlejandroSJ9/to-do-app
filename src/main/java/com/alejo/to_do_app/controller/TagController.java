package com.alejo.to_do_app.controller;

import com.alejo.to_do_app.model.Conect;
import com.alejo.to_do_app.model.Tag;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TagController {

    public static void crearTagDB(Tag tag){
        try {
            PreparedStatement statement = null;
            if(Conect.getConnection() != null){
                try {
                    String query = "INSERT INTO tag (name) VALUES(?)";
                    statement = Conect.getConnection().prepareStatement(query);
                    statement.setString(1,tag.getName());
                    statement.executeUpdate();
                }catch (SQLException e){
                    System.out.println("Error al crear tag: " + e);
                }
            }
        }catch (Exception e ){
            System.out.println("Error: " + e);
        }
    }
}
