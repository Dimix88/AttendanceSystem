package com.dimitri.Repository;

import com.dimitri.domain.Course;

import java.util.Set;

public interface CourseRepository extends Repository<Course, String> {
    Set<Course>getAll();
}
