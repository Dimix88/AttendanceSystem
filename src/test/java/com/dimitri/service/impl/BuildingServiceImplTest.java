package com.dimitri.service.impl;

import com.dimitri.Repository.BuildingRepository;
import com.dimitri.Repository.impl.BuildingRepositoryImpl;
import com.dimitri.domain.Building;
import com.dimitri.factory.BuildingFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class BuildingServiceImplTest {

    private BuildingRepository repository;
    private Building c1;
    Set<Building> buildings = new HashSet<>();


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
        Assert.assertEquals(name,building.getBldgName());
        Assert.assertNotNull(building);
        Assert.assertSame(building, this.c1);
    }

    @Test
    public void update() {
        Building building= this.repository.create(this.c1);
        String newBuildingName = "133";
        Building newBuilding = new Building.Builder().copy(building).bldgName(newBuildingName).build();
        this.repository.create(newBuilding);
        System.out.println("In update, Will update = " + newBuilding);
        Building updated = this.repository.update(newBuilding);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newBuilding.getBldgName(), updated.getBldgName());
    }

    @Test
    public void delete() {
        Building building= this.repository.create(this.c1);
        this.repository.delete(building.getBldgCode());
        System.out.println(this.buildings);
        this.repository.getAll();
    }

    @Test
    public void read() {
        Building building= this.repository.create(this.c1);
        System.out.println("In read, courseId = "+ building.getBldgCode());
        Building read = this.repository.read(building.getBldgCode());
        System.out.println("In read, read = "+ read);
        Assert.assertEquals(c1.getBldgCode(), this.repository.read(c1.getBldgCode()).getBldgCode());
    }



    @Test
    public void getAll() {
        Set<Building> buildingsSet = this.repository.getAll();
        System.out.println("In getAll, all = " + buildingsSet);
        Assert.assertSame(1, buildingsSet.size());
    }
}