package com.example.bookcrud.controller;

import com.example.bookcrud.model.Category;
import com.example.bookcrud.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/get-all-category")
    public List<Category> findALlcategory(){
        return categoryService.getAllCategory();
    }
}
