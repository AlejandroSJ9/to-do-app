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
}
