package com.example.SpringSecvice.entity;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long post_id;

    @NotEmpty(message = "This field cannot be null")
    @Size(min = 5, message = "At least 5 chars")
    private String title;

    @NotEmpty(message = "This field cannot be null")
    private String description;

    private Date date;

    private String creationDate;

    private String photoName;

    private int views;

    public boolean hasImage(){
        return photoName != null;
    }
}
