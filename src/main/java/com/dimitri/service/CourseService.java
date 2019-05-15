package com.dimitri.service;

import com.dimitri.domain.Course;

import java.util.Set;

public interface CourseService extends IService<Course, String> {
    Set<Course>getAll();
}
