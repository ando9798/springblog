package com.example.blogspring.controller;

import com.example.blogspring.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.example.blogspring.repository.PostRepository;

import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostRepository postRepository;

    @GetMapping("/add")
    public String addPostView(ModelMap modelMap) {
        modelMap.addAttribute("categories", postRepository.findAll());
        return "addPost";
    }

    @PostMapping("/add")
    public String home(@ModelAttribute Post post) {
        post.setDate(new Date());
        postRepository.save(post);
        return "redirect:/";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id){
        postRepository.deleteById(id);
        return "redirect:/";
    }


}
