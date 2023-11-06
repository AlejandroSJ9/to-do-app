package com.alejo.to_do_app.controller;

import com.alejo.to_do_app.model.Conect;
import com.alejo.to_do_app.model.Task;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TaskController {
    public static void crearTareaDB(Task task){
        try {
            PreparedStatement statement = null;
            if(Conect.getConnection()!=null){
                try{
                    String query = "INSERT INTO task (name, status, description, priority) VALUES (?,?,?,?)";
                    statement = Conect.getConnection().prepareStatement(query);
                    statement.setString(1, task.getName());
                    statement.setString(2, task.getStatus());
                    statement.setString(3, task.getDescription());
                    statement.setString(4, task.getPriority());
                    statement.executeUpdate();
                }catch (SQLException e){
                    System.out.println("Error SQL creando tarea: " + e);
                }
            }
        }catch (Exception e){
            System.out.println("Error creando tarea: "+ e);
        }

    }
}
