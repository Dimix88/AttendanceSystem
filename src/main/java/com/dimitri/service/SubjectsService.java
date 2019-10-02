package com.dimitri.service;

import com.dimitri.domain.CollegeSubjects;

import java.util.List;

public interface SubjectsService extends IService<CollegeSubjects, String> {
    List<CollegeSubjects> getAll();
}
