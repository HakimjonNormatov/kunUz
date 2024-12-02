package org.example.kunuz.controller;

import org.example.kunuz.dto.ProfileDto;
import org.example.kunuz.model.Profile;
import org.example.kunuz.model.Result;
import org.example.kunuz.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @GetMapping  //✔️
    public List<Profile> getAll(){
        return profileService.getAll();
    }
    @GetMapping("/{id}")//✔️
    public Profile getById(@PathVariable Long id){
        return profileService.getById(id);
    }
    @PostMapping//✔️
    public Result create(@RequestBody ProfileDto profileDto){
        return profileService.add(profileDto);
    }
    @PutMapping("/{id}")//✖️
    public Result update(@PathVariable Long id , @RequestBody ProfileDto profileDto){
        return profileService.update(id , profileDto);
    }
    @DeleteMapping("/{id}")//✔️
    public Result delete(@PathVariable Long id){
        return profileService.delete(id);
    }
    //CreatedDate ✖️





}
