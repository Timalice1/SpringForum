package com.example.SpringSecvice.controllers;

import com.example.SpringSecvice.entity.Post;
import com.example.SpringSecvice.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping()
    public String add(@ModelAttribute("post") Post post) {
        return "post";
    }

    @PostMapping()
    public String newpost(@ModelAttribute("post") @Valid Post post, BindingResult bindingResult,
                          @RequestParam(value = "photo", required = false) MultipartFile img) {

        if(bindingResult.hasErrors()) {
            return "post";
        }

        if(!img.isEmpty()){
            postService.add(post, img);
            return "redirect:/all";
        }

        postService.add(post);
        return "redirect:/all";
    }



}
