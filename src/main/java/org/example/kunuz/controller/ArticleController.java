package org.example.kunuz.controller;

import org.example.kunuz.dto.ArticleDto;
import org.example.kunuz.model.Article;
import org.example.kunuz.model.Result;
import org.example.kunuz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/article") //✖️
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping
    public List<Article> getAll(){
        return articleService.getAll();
    }
    @GetMapping("/{id}")
    public Article getById(@PathVariable UUID id){
        return articleService.getById(id);
    }

    @PostMapping
    public Result create(@RequestBody ArticleDto articleDto){
        return articleService.add(articleDto);
    }

    @PutMapping("/{id}")
    public Result put(@PathVariable UUID id, @RequestBody ArticleDto articleDto){
        return articleService.update(id, articleDto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable UUID id){
        return articleService.delete(id);
    }

}
