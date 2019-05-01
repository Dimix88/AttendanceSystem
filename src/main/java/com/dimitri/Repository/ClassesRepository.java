package com.dimitri.Repository;

import com.dimitri.domain.Classes;

import java.util.Set;

public interface ClassesRepository extends Repository<Classes, String> {
    Set<Classes>getAll();
}
