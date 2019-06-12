package com.dimitri.repository;

import com.dimitri.domain.Course;
import com.dimitri.repository.IRepository;
import org.springframework.stereotype.Repository;
import java.util.Set;

public interface CourseIRepository extends IRepository<Course, String> {
    Set<Course>getAll();
}
