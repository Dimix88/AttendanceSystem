package com.dimitri.Repository.impl;

import com.dimitri.Repository.BuildingRepository;
import com.dimitri.domain.Building;
import com.dimitri.factory.BuildingFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class BuildingRepositoryImplTest {
    private BuildingRepository repository;
    private Building c1;


    private Building getSavedClass(){
        Set<Building> buildings = this.repository.getAll();
        this.repository.create(this.c1);
        return buildings.iterator().next();
    }
    @Before
    public void setUp() throws Exception {
        this.repository = BuildingRepositoryImpl.getRepository();
        c1 = BuildingFactory.getBuilding("A-Building","21 Street");

    }
    @Test
    public void create() {
        Building building= this.repository.create(this.c1);
        String name = "A-Building";
        System.out.println("In create, created = " + building);
        getAll();
        Assert.assertEquals(name,building.getBldgName());
        Assert.assertNotNull(building);
        Assert.assertSame(building, this.c1);
    }

    @Test
    public void update() {
        String newBuildingName = "133";
        Building newBuilding = new Building.Builder().copy(getSavedClass()).bldgName(newBuildingName).build();
        System.out.println("In update, Will update = " + newBuilding);
        Building updated = this.repository.update(newBuilding);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newBuilding.getBldgName(), updated.getBldgName());
        getAll();
    }

    @Test
    public void delete() {
        Building building = getSavedClass();
        this.repository.delete(building.getBldgCode());
        getAll();
    }

    @Test
    public void read() {
        Building saved = getSavedClass();
        System.out.println("In read, courseId = "+ saved.getBldgCode());
        Building read = this.repository.read(saved.getBldgCode());
        System.out.println("In read, read = "+ read);
        getAll();
        Assert.assertEquals(read, saved);
    }



    @Test
    public void getAll() {
        Set<Building> buildings = this.repository.getAll();
        System.out.println("In getAll, all = " + buildings);
        Assert.assertSame(1, buildings.size());
    }
}