package com.dimitri.Repository;

import com.dimitri.domain.Building;

import java.util.Set;

public interface BuildingRepository extends Repository<Building, String> {
    Set<Building>getAll();
}
