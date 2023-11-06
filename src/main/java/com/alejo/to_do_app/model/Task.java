package com.alejo.to_do_app.model;

import java.util.Date;

public class Task {
    private Integer id_task;
    private String name;
    private String status;
    private String description;
    private Date created_at;
    private Date finished_at;
    private String priority;
    private Tag tag;

    public enum Status{
        DONE, IN_PROGRESS, PENDING
    }
    public enum Priority{
        HIGH, NORMAL, LOW
    }

    public Task (String name, String status, String description, String priority) {
        this.name = name;
        this.status = status;
        this.description = description;
        this.priority = priority;
    }

    public Task(){}

    public Integer getId_task () {
        return id_task;
    }

    public void setId_task (Integer id_task) {
        this.id_task = id_task;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getStatus () {
        return status;
    }

    public void setStatus (String status) {
        this.status = status;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public Date getCreated_at () {
        return created_at;
    }

    public void setCreated_at (Date created_at) {
        this.created_at = created_at;
    }

    public Date getFinished_at () {
        return finished_at;
    }

    public void setFinished_at (Date finished_at) {
        this.finished_at = finished_at;
    }

    public String getPriority () {
        return priority;
    }

    public void setPriority (String priority) {
        this.priority = priority;
    }

    public Tag getTag () {
        return tag;
    }

    public void setTag (Tag tag) {
        this.tag = tag;
    }
}
