package com.example.blogspring.controller;


import com.example.blogspring.model.Category;
import com.example.blogspring.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;
     @GetMapping("/add")
    public String addCategoryView(ModelMap modelMap){
         modelMap.addAttribute("category",categoryRepository.findAll());
         return "addCategory";
     }
     @PostMapping("/add")
    public String addCategory(@ModelAttribute Category category){
         categoryRepository.save(category);
         return "addCategory";
     }


}
