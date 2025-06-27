package com.startkit.demo.controllers;

import com.startkit.demo.dao.CategoryDao;
import com.startkit.demo.models.Category;
import com.startkit.demo.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryDao categoryDao;

    @Autowired
    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }
    //just do get

    @GetMapping
    public ResponseEntity<List<Category>> getAll(){
        var category = categoryDao.getAllCategories();
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

}
