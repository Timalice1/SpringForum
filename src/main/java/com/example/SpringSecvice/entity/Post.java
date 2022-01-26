package com.example.SpringSecvice.entity;


import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
    
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long post_id;

    @NotNull(message = "This field cannot be empty")
    private String title;

    @NotNull(message = "This field cannot be empty")
    private String description;

    private String creationDate;

    private String photoName;

    private int views;
}
