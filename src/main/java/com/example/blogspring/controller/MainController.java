package com.example.blogspring.controller;

import com.example.blogspring.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.blogspring.repository.PostRepository;



@Controller
public class MainController {
    @Autowired
    PostRepository postRepository;


    @GetMapping("/")
    public String main(ModelMap modelMap){
        modelMap.addAttribute("posts",postRepository.findAll());
        return "index";
    }

}
