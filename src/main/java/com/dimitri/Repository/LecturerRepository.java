package com.dimitri.Repository;

import com.dimitri.domain.Lecturer;

import java.util.Set;

public interface LecturerRepository extends Repository<Lecturer, String> {
    Set<Lecturer>getAll();
}
