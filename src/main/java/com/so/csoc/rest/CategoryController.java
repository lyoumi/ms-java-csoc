package com.so.csoc.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.so.csoc.data.Category;
import java.util.List;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping
@AllArgsConstructor
public class CategoryController {

    private final List<Category> categories;

    @GetMapping
    public List<Category> getAllCategories() {
        return categories;
    }
}
