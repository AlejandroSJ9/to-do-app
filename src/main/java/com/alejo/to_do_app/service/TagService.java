package com.alejo.to_do_app.service;

import com.alejo.to_do_app.controller.TaskController;
import com.alejo.to_do_app.model.Conect;
import com.alejo.to_do_app.model.Tag;
import com.alejo.to_do_app.controller.TagController;
import com.alejo.to_do_app.model.Task;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Scanner;

public class TagService {
    private static Scanner scanner = new Scanner(System.in);
    public static void crearTag(){
        System.out.println("Name: ");
        String name = scanner.nextLine();
        Tag tag = new Tag(name);
        TagController.crearTagDB(tag);
        System.out.println("---Tag Created---");
    }
    public static void getTag(){
        List<Tag> data = TagController.getTagDB();
        if(!data.isEmpty()){
            int items = 1;
            for(Tag tag: data){

                System.out.println("*****************"+items+"*******************");
                System.out.println("<--" +tag.getName() +"-->");
                System.out.println("*************************************");
                items++;
            }
        }else{
            System.out.println("You dont have tasks yet");
        }

    }
    public static void updateTag(){
        try{
            getTag();
            List<Tag> data = TagController.getTagDB();
            System.out.println("What tag do you want to edit: ");
            Tag tag = data.get(scanner.nextInt() -1);
            //-------------------------------------------
            scanner.nextLine();
            System.out.println("New name: ");
            String name = scanner.nextLine();

            tag.setName(name);
            TagController.updateTagDB(tag);
        }catch (Exception e){
            System.out.println("Error: " + e);
        }
    }
}
