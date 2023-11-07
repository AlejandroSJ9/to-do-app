package com.alejo.to_do_app.service;

import com.alejo.to_do_app.controller.TaskController;
import com.alejo.to_do_app.model.*;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
public class TaskService {
    private static Scanner scanner = new Scanner(System.in);
    public static void createTask(){
        try{
            //Get data user
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
            int items = 1;
            for(Task task: data){

                System.out.println("*****************"+items+"*******************");
                System.out.println("<--" +task.getName() +"-->");
                System.out.println("description: " +  task.getDescription());
                System.out.println("  -" + task.getPriority());
                System.out.println("  -" + task.getStatus());
                System.out.println("  -" + task.getCreated_at().toString());
                System.out.println("  -" + task.getDone());
                System.out.println("*************************************");
                items++;
            }
        }else{
            System.out.println("You dont have tasks yet");
        }

    }

    private static boolean compareStatus(String original, String newPriority){
        return original.equals(newPriority);
    }
    public static void updateTask(){
        try {
            List<Task> data = TaskController.getTaskDB();
            if(!data.isEmpty()){
                getTask();
                System.out.println("What task do you want to update: ");
                Task task = data.get(scanner.nextInt()-1);
                System.out.println(task.toString());
                //----------------------------------
                scanner.nextLine();
                String name, description, status, priority;
                System.out.println("New name: ");
                name = scanner.nextLine();
                task.setName(name);
                //----------------------------------
                System.out.println("New description: ");
                description = scanner.nextLine();
                task.setDescription(description);
                //----------------------------------se puede hacer mejor
                System.out.println("New priority: \n1. High\n2. Normal\n3. Low");
                status = scanner.nextLine();
                switch (status){
                    case "1":
                        if(!compareStatus(task.getPriority(),Task.Priority.HIGH.name())){
                            task.setPriority(Task.Priority.HIGH.name());
                        }else{
                            System.out.println("This is current priority");
                        }
                        break;
                    case "2":
                        if(!compareStatus(task.getPriority(),Task.Priority.NORMAL.name())){
                            task.setPriority(Task.Priority.NORMAL.name());
                        }else{
                            System.out.println("This is current priority");
                        }
                        break;
                    case "3":
                        if(!compareStatus(task.getPriority(),Task.Priority.LOW.name())){
                            task.setPriority(Task.Priority.LOW.name());
                        }else{
                            System.out.println("This is current priority");
                        }
                        break;
                    default:
                        System.out.println("Error: opcion invalida");
                }
                //----------------------------------
                System.out.println("New status: \n1. Done\n2. In progress\n3. Pending");
                status = scanner.nextLine();
                switch (status){
                    case "1":
                        if(!compareStatus(task.getStatus(),Task.Status.DONE.name())){
                            task.setPriority(Task.Status.DONE.name());
                        }else{
                            System.out.println("This is current priority");
                        }
                        break;
                    case "2":
                        if(!compareStatus(task.getStatus(),Task.Status.IN_PROGRESS.name())){
                            task.setPriority(Task.Status.IN_PROGRESS.name());
                        }else{
                            System.out.println("This is current priority");
                        }
                        break;
                    case "3":
                        if(!compareStatus(task.getStatus(),Task.Status.PENDING.name())){
                            task.setPriority(Task.Status.PENDING.name());
                        }else{
                            System.out.println("This is current priority");
                        }
                        break;
                    default:
                        System.out.println("Error: opcion invalida");
                }
                //---------------------------------
                TaskController.updateTaskDB(task);

            }else {
                System.out.println("You dont have task yet");
            }

        }catch (Exception e){
            System.out.println("Error: " + e);
        }
    }

}
