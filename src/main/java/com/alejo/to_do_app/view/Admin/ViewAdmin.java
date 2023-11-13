package com.alejo.to_do_app.view.Admin;

import com.alejo.to_do_app.service.TagService;
import com.alejo.to_do_app.service.TaskService;

import java.util.Scanner;

public class ViewAdmin {
    public static void showAdminView(){
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        do{
            System.out.println("<--To Do APP-->\n1. Create task \n2. View Task\n3. Update Task\n4. Delete task\n-----------\n5. Create tag\n6. Get tag\n7. Update tag");
            option = scanner.nextInt();
            switch (option){
                case 1:
                    TaskService.createTask();
                    break;
                case 2:
                    TaskService.getTask();
                    break;
                case 3:
                    TaskService.updateTask();
                    break;
                case 4:
                    TaskService.deleteTask();
                    break;
                case 5:
                    TagService.crearTag();
                    break;
                case 6:
                    TagService.getTag();
                    break;
                case 7:
                    TagService.updateTag();
            }
        }while (option != 0);
    }
}
