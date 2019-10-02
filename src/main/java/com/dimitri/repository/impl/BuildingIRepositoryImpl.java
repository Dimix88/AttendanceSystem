/**package com.dimitri.repository.impl;

import com.dimitri.repository.BuildingIRepository;
import com.dimitri.domain.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Repository("BuildingRepository")
public class BuildingIRepositoryImpl implements BuildingIRepository {
    @Autowired
    private static BuildingIRepositoryImpl repository = null;
    private Set<Building>buildings;

    private BuildingIRepositoryImpl(){
        this.buildings = new HashSet<>();
    }

    private Building findBuilding(String bldgCode){
        for (Building classes2: this.buildings){
            if (classes2.getBldgCode().equals(bldgCode))
                return classes2;
        }
        return null;    }
    public static BuildingIRepository getRepository(){
        if(repository == null) repository = new BuildingIRepositoryImpl();
        return repository;
    }
    @Override
    public Building create(Building building) {
        this.buildings.add(building);
        return building;
    }

    @Override
    public Building update(Building bldg) {
        Building toDelete = findBuilding(bldg.getBldgCode());
        if(toDelete != null) {
            this.buildings.remove(toDelete);
            return create(bldg);
        }
        return null;
    }

    @Override
    public void delete(String bldgCode) {
        Building class1 = findBuilding(bldgCode);
        if(class1 != null){
            this.buildings.remove(class1);
        }    }

    @Override
    public Building read(String bldgCode) {
        return findBuilding(bldgCode);
    }
    public Set<Building> getAll(){
        return this.buildings;
    }
}
**/