package com.dimitri.service;

import com.dimitri.domain.Building;

import java.util.Set;

public interface BuildingService extends IService<Building, String> {
    Set<Building>getAll();
}

