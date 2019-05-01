package com.dimitri.Repository;

import com.dimitri.domain.Student;

import java.util.Set;

public interface StudentRepository extends Repository<Student, String> {
    Set<Student>getAll();
}
