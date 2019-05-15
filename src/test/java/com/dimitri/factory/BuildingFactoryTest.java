package com.dimitri.factory;

import com.dimitri.domain.Building;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuildingFactoryTest {

    @Test
    public void getBuilding() {
        String name = "T22";
        Building b = BuildingFactory.getBuilding("T22", "Belville");
        Assert.assertEquals(name, b.getBldgName());
        Assert.assertNotNull(b);
    }
}