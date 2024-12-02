package org.example.kunuz.controller;

import org.example.kunuz.dto.SavedArticleDto;
import org.example.kunuz.model.Result;
import org.example.kunuz.model.SavedArticle;
import org.example.kunuz.service.SavedArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/savedArticle")//✖️
public class SavedArticleController {

    @Autowired
    SavedArticleService savedArticleService;

    @GetMapping
    public List<SavedArticle>getAll(){
        return savedArticleService.getAll();
    }
    @GetMapping("/{id}")
    public SavedArticle getById(@PathVariable Long id){
        return savedArticleService.getById(id);
    }
    @PostMapping
    public Result create(@RequestBody SavedArticleDto savedArticleDto){
        return savedArticleService.add(savedArticleDto);
    }
    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody SavedArticleDto savedArticleDto){
        return savedArticleService.update(id,savedArticleDto);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        return savedArticleService.delete(id);
    }

}
