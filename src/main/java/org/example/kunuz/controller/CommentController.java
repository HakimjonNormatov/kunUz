package org.example.kunuz.controller;

import org.example.kunuz.dto.CommentDto;
import org.example.kunuz.model.Comment;
import org.example.kunuz.model.Result;
import org.example.kunuz.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")//✖️
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping
    public List<Comment> getAll(){
        return commentService.getAll();
    }
    @GetMapping("/{id}")
    public Comment getById(@PathVariable Long id){
        return commentService.getById(id);
    }
    @PostMapping
    public Result create(@RequestBody CommentDto commentDto){
        return commentService.add(commentDto);
    }
    @PutMapping("/{id}")
    public Result update(@PathVariable Long id , @RequestBody CommentDto commentDto) {
        return commentService.update(id , commentDto);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        return commentService.delete(id);
    }

}
