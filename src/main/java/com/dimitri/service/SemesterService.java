package com.dimitri.service;

import com.dimitri.domain.Semester;

import java.util.List;

public interface SemesterService extends IService<Semester, String> {
    List<Semester> getAll();
}