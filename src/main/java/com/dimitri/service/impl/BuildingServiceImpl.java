package com.dimitri.service.impl;

import com.dimitri.repository.BuildingIRepository;
//import com.dimitri.repository.impl.BuildingIRepositoryImpl;
import com.dimitri.domain.Building;
import com.dimitri.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("BuildingServiceImpl")
public class BuildingServiceImpl implements BuildingService {
    public static BuildingService buildingService = null;

    @Autowired
    private BuildingIRepository repository;

    private BuildingServiceImpl(){}

    public static BuildingService getBuildingService(){
        if(buildingService==null)buildingService = new BuildingServiceImpl();
        return buildingService;
    }
    @Override
    public List<Building> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Building create(Building building) {
        return this.repository.save(building);
    }

    @Override
    public Building update(Building building) {
        return this.repository.save(building);
    }

    @Override
    public void delete(String s) {
            this.repository.deleteById(s);

    }

    @Override
    public Building read(String s) {
        Optional<Building>optionalBuilding = this.repository.findById(s);
        return optionalBuilding.orElse(null);
    }
}
