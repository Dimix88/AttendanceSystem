package com.dimitri.factory;

import com.dimitri.domain.Building;
import com.dimitri.util.IdGenerator;

public class BuildingFactory {

    public static Building getBuilding(String bName, String bLocation){
        return new Building.Builder().bldgCode(IdGenerator.generateId())
                .bldgName(bName)
                .bldgLocation(bLocation)
                .build();
    }
}
