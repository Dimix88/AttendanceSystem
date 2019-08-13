package com.dimitri.service.impl;

import com.dimitri.repository.BuildingIRepository;
import com.dimitri.repository.impl.BuildingIRepositoryImpl;
import com.dimitri.domain.Building;
import com.dimitri.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("BuildingServiceImpl")
public class BuildingServiceImpl implements BuildingService {
        @Autowired
        @Qualifier("BuildingRepository")
        private BuildingIRepository repository = null;

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
