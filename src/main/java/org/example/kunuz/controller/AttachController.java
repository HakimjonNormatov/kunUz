package org.example.kunuz.controller;

import org.example.kunuz.dto.AttachDto;
import org.example.kunuz.model.Attach;
import org.example.kunuz.model.Result;
import org.example.kunuz.service.AttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/attach")
public class AttachController {

    @Autowired
    AttachService attachService;

    @GetMapping//✔️
    public List<Attach> getAll() {
        return attachService.getAll();
    }

    @GetMapping("/{id}")//✔️
    public Attach getById(@PathVariable UUID id) {
        return attachService.getById(id);
    }

    @PostMapping//✔️
    public Result add(@RequestBody AttachDto attachDto) {
        return attachService.add(attachDto);
    }

    @PutMapping("/{id}")//✖️
    public Result update(@PathVariable UUID id, @RequestBody AttachDto attachDto) {
        return attachService.update(id, attachDto);
    }

    @DeleteMapping("/{id}")//✔️
    public Result delete(@PathVariable UUID id) {
        return attachService.delete(id);
    }
    //Created Date ✖️

}
