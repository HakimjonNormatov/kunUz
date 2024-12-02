package org.example.kunuz.controller;

import org.example.kunuz.dto.CommentLikeDto;
import org.example.kunuz.model.CommentLike;
import org.example.kunuz.model.Result;
import org.example.kunuz.service.CommentLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commentLike")//✖️
public class CommentLikeController {

    @Autowired
    CommentLikeService commentLikeService;

    @GetMapping
    public List<CommentLike>getAll(){
        return commentLikeService.getAll();
    }
    @GetMapping("/{id}")
    public CommentLike getById(@PathVariable Long id){
        return commentLikeService.getById(id);
    }
    @PostMapping
    public Result create(@RequestBody CommentLikeDto commentLikeDto){
        return commentLikeService.add(commentLikeDto);
    }
    @PutMapping("/{id}")
    public Result update(@RequestBody CommentLikeDto commentLikeDto, @PathVariable Long id){
        return commentLikeService.update(id , commentLikeDto);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        return commentLikeService.delete(id);
    }

}
