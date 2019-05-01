package com.dimitri.Repository.impl;

import com.dimitri.Repository.BuildingRepository;
import com.dimitri.Repository.Repository;
import com.dimitri.domain.Building;

import java.util.HashSet;
import java.util.Set;

public class BuildingRepositoryImpl implements BuildingRepository {
    private static BuildingRepositoryImpl repository = null;
    private Set<Building>buildings;

    private BuildingRepositoryImpl(){
        this.buildings = new HashSet<>();
    }
    private Building findBuilding(String bldgCode){
        for (Building classes2: this.buildings){
            if (classes2.getBldgCode().equals(bldgCode))
                return classes2;
        }
        return null;    }
    public static BuildingRepository getRepository(){
        if(repository == null) repository = new BuildingRepositoryImpl();
        return repository;
    }
    @Override
    public Building create(Building building) {
        this.buildings.add(building);
        return building;
    }

    @Override
    public Building update(Building bldg) {
        if(this.buildings.contains(bldg)){
            this.buildings.remove(bldg);
            this.buildings.add(bldg);
        }
        return bldg;
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
