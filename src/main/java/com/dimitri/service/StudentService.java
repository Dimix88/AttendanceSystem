package com.dimitri.service;

import com.dimitri.domain.Student;

import java.util.Set;

public interface StudentService extends IService<Student, String> {
    Set<Student>getAll();
}
