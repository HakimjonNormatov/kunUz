package org.example.kunuz.controller;

import org.example.kunuz.dto.Article_TypeDto;
import org.example.kunuz.model.Article_Type;
import org.example.kunuz.model.Result;
import org.example.kunuz.service.Article_TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articleType")
public class Article_TypeController {

    @Autowired
    Article_TypeService articleTypeService;

    @GetMapping //✔️
    public List<Article_Type> getAll() {
        return articleTypeService.getAll();
    }

    @GetMapping("/{id}")//✔️
    public Article_Type getById(@PathVariable Long id) {
        return articleTypeService.getById(id);
    }

    @PostMapping//✔️
    public Result create(@RequestBody Article_TypeDto articleTypeDto) {
        return articleTypeService.add(articleTypeDto);
    }

    @PutMapping("/{id}")//✖️
    public Result update(@PathVariable Long id, @RequestBody Article_TypeDto articleTypeDto) {
        return articleTypeService.update(id, articleTypeDto);
    }

    @DeleteMapping("/{id}")//✔️
    public Result delete(@PathVariable Long id) {
        return articleTypeService.Delete(id);
    }

}
