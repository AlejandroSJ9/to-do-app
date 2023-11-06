import com.alejo.to_do_app.service.TaskService;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        do{
            System.out.println("<--To Do APP-->\n1. Create task \n2. View Task\n3.Update Task\n4. Delete task");
            option = scanner.nextInt();
            switch (option){
                case 1:
                    TaskService.createTask();
            }
        }while (option != 0);
    }
}
