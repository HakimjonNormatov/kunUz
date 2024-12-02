package org.example.kunuz.controller;

import org.example.kunuz.dto.CategoryDto;
import org.example.kunuz.model.Category;
import org.example.kunuz.model.Result;
import org.example.kunuz.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")//✖️
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategory() {
        return categoryService.getAll();
    }
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.getById(id);
    }
    @PostMapping
    public Result addCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.add(categoryDto);
    }
    @PutMapping("/{id}")
    public Result updateCategory(@PathVariable Long id, @RequestBody CategoryDto categoryDto) {
        return categoryService.update(id, categoryDto);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        return categoryService.delete(id);
    }

}
