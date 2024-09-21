package com.ashish.dev.springbootapplication1.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
public class MongoWorkModel {

    @NotBlank(message = "Title is mandatory")
    private String title;

    private String department;
    private String tag;

    @NotBlank(message = "Status is mandatory")
    private String status;

    @NotNull(message = "AssignedTo list cannot be null")
    private List<String> assignedTo;

    private Date targetDate;
}