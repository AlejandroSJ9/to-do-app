package com.alejo.to_do_app.model;

import java.util.ArrayList;

public class Tag {
    private Integer id_tag;
    private String name;
    private ArrayList<Task> taskList;

    public Tag (String name) {
        this.name = name;
    }

    public Tag (Integer id_tag, String name) {
        this.id_tag = id_tag;
        this.name = name;
    }

    public Integer getId_tag () {
        return id_tag;
    }

    public void setId_tag (Integer id_tag) {
        this.id_tag = id_tag;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public ArrayList<Task> getTaskList () {
        return taskList;
    }

    public void setTaskList (ArrayList<Task> taskList) {
        this.taskList = taskList;
    }
}
