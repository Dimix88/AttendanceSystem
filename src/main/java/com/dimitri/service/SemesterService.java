package com.dimitri.service;

import com.dimitri.domain.Semester;

import java.util.Set;

public interface SemesterService extends IService<Semester, String> {
    Set<Semester>getAll();
}