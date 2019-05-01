package com.dimitri.Repository;

import com.dimitri.domain.Semester;

import java.util.Set;

public interface SemesterRepository extends Repository<Semester, String> {
    Set<Semester>getAll();
}
