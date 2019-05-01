package com.dimitri.Repository;

import com.dimitri.domain.Enroll;

import java.util.Set;

public interface EnrollRepository extends Repository<Enroll, String> {
    Set<Enroll>getAll();
}
