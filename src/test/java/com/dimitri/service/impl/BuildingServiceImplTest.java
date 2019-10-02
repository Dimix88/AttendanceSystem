package com.dimitri.service.impl;

import com.dimitri.repository.BuildingIRepository;
//import com.dimitri.repository.impl.BuildingIRepositoryImpl;
import com.dimitri.domain.Building;
import com.dimitri.factory.BuildingFactory;
import com.dimitri.service.BuildingService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BuildingServiceImplTest {
  private BuildingService buildingService;
    private BuildingIRepository repository;
    private Building c1;

    @Before
    public void setUp() throws Exception {
        this.buildingService = BuildingServiceImpl.buildingService;
        c1 = BuildingFactory.getBuilding("A-Building","21 Street");
        buildingService.create(c1);
    }
    @Test
    public void create() {
        Building building= BuildingFactory.getBuilding("Tromp","");
        buildingService.create(building);
        String name = "Tromp";
        Assert.assertEquals(building.getBldgName(),buildingService.read(building.getBldgCode()).getBldgName());
        Assert.assertNotNull(building);
        Assert.assertEquals(name, buildingService.read(building.getBldgCode()).getBldgName());
        Assert.assertSame(building, buildingService.read(building.getBldgCode()));;
    }

    @Test
    public void update() {
        String newBuildingName = "133";
        Building newBuilding = new Building.Builder().copy(c1).bldgName(newBuildingName).build();
        buildingService.update(newBuilding);
        Assert.assertEquals(newBuilding,buildingService.read(c1.getBldgCode()));
    }

    @Test
    public void delete() {
        Building deleteBuilding= BuildingFactory.getBuilding("Pink","");
        buildingService.create(deleteBuilding);
        buildingService.delete(deleteBuilding.getBldgCode());
        Building result = buildingService.read(deleteBuilding.getBldgCode());
        Assert.assertFalse(buildingService.getAll().iterator().next().getBldgName().contains("Pink"));
        Assert.assertNull(result);
    }

    @Test
    public void read() {
        Building read= this.buildingService.create(this.c1);
        Assert.assertEquals(read, buildingService.read(read.getBldgCode()));
        Assert.assertEquals(read, buildingService.read(c1.getBldgCode()));
    }



    @Test
    public void getAll() {
        List<Building> buildingsSet = this.buildingService.getAll();
        System.out.println("In getAll, all = " + buildingsSet);
        Assert.assertSame(buildingsSet.size(),buildingService.getAll().size());
    }
}