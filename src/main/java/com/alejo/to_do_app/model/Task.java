package com.alejo.to_do_app.model;

import java.util.Date;

public class Task {
    private Integer id_task;
    private String name;
    private String status;
    private String description;
    private Date created_at;
    private Boolean done;
    private Date dead_line;
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

    public Task (Integer id_task, String name, String status, String description, Date created_at, Date dead_line, String priority){
        this.id_task = id_task;
        this.name = name;
        this.status = status;
        this.description = description;
        this.created_at = created_at;
        this.dead_line = dead_line;
        this.priority = priority;
    }

    public Task(){}

    public Boolean getDone () {
        return done;
    }

    public void setDone (Boolean done) {
        this.done = done;
    }

    public Date getDead_line () {
        return dead_line;
    }

    public void setDead_line (Date dead_line) {
        this.dead_line = dead_line;
    }

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
        return dead_line;
    }

    public void setFinished_at (Date finished_at) {
        this.dead_line = finished_at;
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

    @Override
    public String toString () {
        return "Your Task{" +
                "id_task=" + id_task +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", created_at=" + created_at +
                ", done=" + done +
                ", dead_line=" + dead_line +
                ", priority='" + priority + '\'' +
                '}';
    }

}
