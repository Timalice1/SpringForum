package com.example.SpringSecvice.controllers;

import com.example.SpringSecvice.entity.Post;
import com.example.SpringSecvice.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/new")
    public String add(@ModelAttribute("post") Post post) {
        return "new-post";
    }

    @PostMapping("/new")
    public String newpost(@ModelAttribute("post") @Valid Post post, BindingResult bindingResult,
                          @RequestParam(value = "photo", required = false) MultipartFile img) {

        if(bindingResult.hasErrors()) {
            return "new-post";
        }

        if(!img.isEmpty()){
            postService.add(post, img);
            return "redirect:/";
        }

        postService.add(post);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String viewPost(@PathVariable("id") Long id, Model model){
        model.addAttribute("post", postService.findById(id));
        return "post";
    }

}
