package com.ashish.dev.springbootapplication1.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class MongoWorkModel {

    @NotBlank(message = "Title is mandatory")
    private String title;

    private String department;
    private String tag;

    @NotBlank(message = "Status is mandatory")
    private String status;

    private Date targetDate;
}