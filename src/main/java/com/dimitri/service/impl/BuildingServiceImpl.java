package com.dimitri.service.impl;

import com.dimitri.Repository.BuildingRepository;
import com.dimitri.Repository.impl.BuildingRepositoryImpl;
import com.dimitri.domain.Building;
import com.dimitri.service.BuildingService;

import java.util.Set;

public class BuildingServiceImpl implements BuildingService {
        private static BuildingServiceImpl service = null;
        private BuildingRepository repository = null;

        private BuildingServiceImpl(){
            this.repository = BuildingRepositoryImpl.getRepository();
    }
    public static BuildingServiceImpl getService(){
            if(service == null) service = new BuildingServiceImpl();
            return service;
    }
    @Override
    public Set<Building> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Building create(Building building) {
        return this.repository.create(building);
    }

    @Override
    public Building update(Building building) {
        return this.repository.update(building);
    }

    @Override
    public void delete(String s) {
            this.repository.delete(s);

    }

    @Override
    public Building read(String s) {
        return this.repository.read(s);
    }
}
