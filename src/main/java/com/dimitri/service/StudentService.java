package com.dimitri.service;

import com.dimitri.domain.Student;

import java.util.List;

public interface StudentService extends IService<Student, String> {
    List<Student> getAll();
}
