package com.alejo.to_do_app.controller;

import com.alejo.to_do_app.model.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public static List getTaskDB(){
        List<Task> data = new ArrayList<>();
        try {
            PreparedStatement statement = null;
            if(Conect.getConnection()!=null){
                try{
                    String query = "SELECT * FROM task";
                    statement = Conect.getConnection().prepareStatement(query);
                    ResultSet rs = statement.executeQuery();
                    while (rs.next()){
                        int id = rs.getInt("id_task");
                        String name = rs.getString("name");
                        String status = rs.getString("status");
                        String description = rs.getString("description");
                        Date created_at = rs.getDate("created_at");
                        Date dead_line = rs.getDate("dead_line");
                        String priority = rs.getString("priority");
                        Task task = new Task(id,name,status,description,created_at,dead_line,priority);
                        data.add(task);
                    }

                }catch (SQLException e){
                    System.out.println("Error SQL creando tarea: " + e);
                }
            }
        }catch (Exception e){
            System.out.println("Error obteniendo tarea: "+ e);
        }
        return data;
    }
    public static void updateTaskDB(Task task){
        try {
            PreparedStatement statement = null;
            if(Conect.getConnection()!=null){
                try{
                    String query = "UPDATE task SET name = ?, status = ?, description = ?, priority = ? WHERE task.id_task = ?";
                    statement = Conect.getConnection().prepareStatement(query);
                    statement.setString(1, task.getName());
                    statement.setString(2, task.getStatus());
                    statement.setString(3, task.getDescription());
                    statement.setString(4, task.getPriority());
                    statement.setString(5, task.getId_task().toString());
                    statement.executeUpdate();
                }catch (SQLException e){
                    System.out.println("Error SQL actualizando tarea: " + e);
                }
            }
        }catch (Exception e){
            System.out.println("Error actualizando tarea: "+ e);
        }
    }
}
