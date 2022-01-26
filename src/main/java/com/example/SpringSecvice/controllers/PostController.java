package com.example.SpringSecvice.controllers;

import com.example.SpringSecvice.entity.Post;
import com.example.SpringSecvice.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/new-post")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping()
    public String add() {
        return "post";
    }

    @PostMapping()
    public String newpost(@ModelAttribute("post")Post post, BindingResult bindingResult,
                          @RequestParam(value = "photo", required = false) MultipartFile img) {

        if(!img.isEmpty()){
            if(!postService.add(post, bindingResult, img))
                return "post";
            return "redirect:/all";
        }

        if(!postService.add(post, bindingResult))
            return "post";

        return "redirect:/all";
    }



}
