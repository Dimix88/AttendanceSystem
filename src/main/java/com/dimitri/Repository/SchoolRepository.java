package com.dimitri.Repository;

import com.dimitri.domain.School;

import java.util.Set;

public interface SchoolRepository extends Repository<School, String> {
    Set<School> getAll();
}
