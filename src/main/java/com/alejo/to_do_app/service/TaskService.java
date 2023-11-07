package com.alejo.to_do_app.service;

import com.alejo.to_do_app.controller.TaskController;
import com.alejo.to_do_app.model.*;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
public class TaskService {
    public static void createTask(){
        try{
            //Get data user
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingresa el nombre de la tarea: ");
            String name = scanner.nextLine();
            System.out.println("<-Prioridad->\n1. High\n2. Normal\n3. Low");
            int priorityChoise = scanner.nextInt();
            scanner.nextLine();
            String priorityFinal = "";
            switch (priorityChoise){
                case 1:
                    priorityFinal = Task.Priority.HIGH.name();
                    break;
                case 2:
                    priorityFinal = Task.Priority.NORMAL.name();
                    break;
                case 3:
                    priorityFinal = Task.Priority.LOW.name();
                    break;
                default:
                    System.out.println("Error: Opcion invalida");
                    break;
            }
            System.out.println("If you want add description to " + name + ": (press 0 to carry on without description)");
            String description = scanner.nextLine();
            //Creating an object
            Task task = new Task();
            task.setName(name);
            if(!Objects.equals(description, "0")){
                task.setDescription(description);
            }else{
                task.setDescription("");
            }
            task.setPriority(priorityFinal);
            task.setStatus(Task.Status.PENDING.name());
            task.setDone(false);
            //Sending to service
            TaskController.crearTareaDB(task);

        }catch (Exception e){
            System.out.println("Error: " + e);
            createTask();
        }

    }
    public static void getTask(){
        List<Task> data = TaskController.getTaskDB();
        if(!data.isEmpty()){
            for(Task task: data){
                System.out.println("*************************************");
                System.out.println("<--" +task.getName() +"-->");
                System.out.println("description: " +  task.getDescription());
                System.out.println("  -" + task.getPriority());
                System.out.println("  -" + task.getStatus());
                System.out.println("  -" + task.getCreated_at().toString());
                System.out.println("  -" + task.getDone());
                System.out.println("*************************************");
            }
        }else{
            System.out.println("You dont have tasks yet");
        }

    }
    public static void updateTask(){

    }
}
