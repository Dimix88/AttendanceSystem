package com.dimitri.controller;
import com.dimitri.domain.Building;
import com.dimitri.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/building")
public class   BuildingController {

    @Autowired
    @Qualifier("BuildingServiceImpl")
    private BuildingService service;

    @PostMapping("/create")
    @ResponseBody
    public Building create(@RequestBody Building building){
        return service.create(building);
    }

    @PutMapping("/update")
    @ResponseBody
    public Building update(@RequestBody Building building){
        return service.update(building);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Building read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Building> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }

}
