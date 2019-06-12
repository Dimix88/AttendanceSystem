package com.dimitri.repository;

import com.dimitri.domain.Building;
import com.dimitri.repository.IRepository;
import org.springframework.stereotype.Repository;
import java.util.Set;

public interface BuildingIRepository extends IRepository<Building, String> {
    Set<Building>getAll();
}
