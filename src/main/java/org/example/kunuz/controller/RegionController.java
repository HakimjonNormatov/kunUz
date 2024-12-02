package org.example.kunuz.controller;

import org.example.kunuz.dto.RegionDto;
import org.example.kunuz.model.Region;
import org.example.kunuz.model.Result;
import org.example.kunuz.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/region")
public class RegionController {

    @Autowired
    RegionService regionService;

    @GetMapping//✔️
    public List<Region> getAllRegions() {
        return regionService.getAll();
    }
    @GetMapping("/{id}")//✔️
    public Region getById(@PathVariable Long id) {
        return regionService.getById(id);
    }
    @PostMapping//✔️
    public Result createRegion(@RequestBody RegionDto regionDto) {
        return regionService.add(regionDto);
    }
    @PutMapping("/{id}")//✖️
    public Result updateRegion(@PathVariable Long id, @RequestBody RegionDto regionDto) {
        return regionService.update(id, regionDto);
    }
    @DeleteMapping("/{id}")//✔️
    public Result delete(@PathVariable Long id){
        return regionService.delete(id);
    }

    //CreatedDate ✖️

}
