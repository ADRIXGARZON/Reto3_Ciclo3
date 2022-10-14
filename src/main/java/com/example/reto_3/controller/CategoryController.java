package com.example.reto_3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.reto_3.entities.Category;
import com.example.reto_3.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/api/Category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getCategory(){
        return categoryService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id") int categoryId) {
        return categoryService.getCategory(categoryId);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody  Category category){
        return categoryService.save(category);
    }
}
