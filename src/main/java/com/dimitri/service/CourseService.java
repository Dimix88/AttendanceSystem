package com.dimitri.service;

import com.dimitri.domain.Course;

import java.util.List;

public interface CourseService extends IService<Course, String> {
    List<Course> getAll();
}
