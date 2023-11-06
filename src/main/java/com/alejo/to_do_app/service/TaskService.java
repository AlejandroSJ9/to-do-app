package com.alejo.to_do_app.service;

import com.alejo.to_do_app.controller.TaskController;
import com.alejo.to_do_app.model.Task;

import java.util.Objects;
import java.util.Scanner;
import com.alejo.to_do_app.model.Task;
public class TaskService {
    public static void createTask(){
        try{
            //Get data user
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingresa el nombre de la tarea: ");
            String name = scanner.nextLine();
            System.out.println("<-Prioridad->\n1. High\n2. Normal\n3. Low");
            int priorityChoise = scanner.nextInt();
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
            System.out.println("If you want add description to " + name + ": (press 0 to carry on without description");
            String description = scanner.next();
            //Creating an object
            Task task = new Task();
            task.setName(name);
            if(!Objects.equals(description, "0")){
                task.setDescription(description);
            }else{
                task.setDescription("");
            }
            task.setPriority(priorityFinal);
            task.setStatus(Task.Status.IN_PROGRESS.name());
            //Sending to service
            TaskController.crearTareaDB(task);
        }catch (Exception e){
            System.out.println("Error: " + e);
            createTask();
        }

    }
}
