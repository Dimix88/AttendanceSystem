package com.dimitri.Repository;

import com.dimitri.domain.Subjects;

import java.util.Set;

public interface SubjectsRepository extends Repository<Subjects, String> {
    Set<Subjects>getAll();
}
