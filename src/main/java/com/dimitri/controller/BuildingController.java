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
    @Qualifier("ServiceImpl20")

    private BuildingService service;

    @PostMapping("/create")
    @ResponseBody
    public Building create(Building building){
        return service.create(building);
    }

    @PostMapping("/update")
    @ResponseBody
    public Building update(Building building){
        return service.update(building);
    }

    @PostMapping("/read/{id}")
    @ResponseBody
    public Building read(@PathVariable String id){
        return service.read(id);
    }

    @PostMapping("/read/all")
    @ResponseBody
    public Set<Building> getAll(){
        return service.getAll();
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }

}
