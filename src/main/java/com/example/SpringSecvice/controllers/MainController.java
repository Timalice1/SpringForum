package com.example.SpringSecvice.controllers;

import com.example.SpringSecvice.entity.Post;
import com.example.SpringSecvice.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    PostService postService;


    @GetMapping("/all")
    public String index(Model model){
        model.addAttribute("posts", postService.findAll());
        return "all";
    }

}
