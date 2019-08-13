package com.dimitri.service.impl;

import com.dimitri.repository.CourseIRepository;
import com.dimitri.repository.impl.CourseIRepositoryImpl;
import com.dimitri.domain.Course;
import com.dimitri.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service("CourseServiceImpl")
public class CourseServiceImpl implements CourseService {
    @Autowired
    @Qualifier("CourseRepository")
    private CourseIRepository repository = null;

    @Override
    public Set<Course> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Course create(Course course) {
        return this.repository.create(course);
    }

    @Override
    public Course update(Course course) {
        return this.repository.update(course);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Course read(String s) {
        return this.repository.read(s);
    }
}
