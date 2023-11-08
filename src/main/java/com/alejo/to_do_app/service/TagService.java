package com.alejo.to_do_app.service;

import com.alejo.to_do_app.model.Tag;
import com.alejo.to_do_app.controller.TagController;
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
}
