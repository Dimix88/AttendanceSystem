package com.dimitri.controller;
import com.dimitri.domain.Building;
import com.dimitri.factory.BuildingFactory;
import com.dimitri.service.impl.BuildingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/dimitri/building")
public class BuildingController {

    @Autowired
    private BuildingServiceImpl service;

    @GetMapping("/create/{bName, bLocation}")
    public @ResponseBody
    Building create (@PathVariable String buildingName, String buildingLocation){
        Building building = BuildingFactory.getBuilding(buildingName,buildingLocation);
        return service.create(building);
    }

    @GetMapping ("/getall")
    @ResponseBody
    Set<Building>getAll(){
        return service.getAll();
    }

}
