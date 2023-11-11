package com.alejo.to_do_app.controller;

import com.alejo.to_do_app.model.Conect;
import com.alejo.to_do_app.model.Tag;
import com.alejo.to_do_app.model.Task;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public static List<Tag> getTagDB(){
        List<Tag> data = new ArrayList<>();
        try {
            PreparedStatement statement = null;
            if(Conect.getConnection()!=null){
                try{
                    String query = "SELECT * FROM tag";
                    statement = Conect.getConnection().prepareStatement(query);
                    ResultSet rs = statement.executeQuery();
                    while (rs.next()){
                        int id = rs.getInt("id_tag");
                        String name = rs.getString("name");
                        Tag tag = new Tag(id,name);
                        data.add(tag);
                    }
                }catch (SQLException e){
                    System.out.println("Error SQL obteniendo tag: " + e);
                }
            }
        }catch (Exception e){
            System.out.println("Error obteniendo tag: "+ e);
        }
        return data;
    }
}
