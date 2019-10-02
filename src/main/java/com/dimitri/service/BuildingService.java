package com.dimitri.service;

import com.dimitri.domain.Building;

import java.util.List;

public interface BuildingService extends IService<Building, String> {
    List<Building> getAll();
}

