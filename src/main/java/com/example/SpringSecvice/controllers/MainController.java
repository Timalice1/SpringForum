package com.example.SpringSecvice.controllers;

import com.example.SpringSecvice.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    PostService postService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postService.findAllSortByDate());
        return "index";
    }

}
