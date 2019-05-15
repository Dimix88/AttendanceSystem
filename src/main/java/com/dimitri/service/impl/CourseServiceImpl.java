package com.dimitri.service.impl;

import com.dimitri.Repository.CourseRepository;
import com.dimitri.Repository.impl.CourseRepositoryImpl;
import com.dimitri.domain.Course;
import com.dimitri.service.CourseService;

import java.util.Set;

public class CourseServiceImpl implements CourseService {
    private static CourseServiceImpl service = null;
    private CourseRepository repository = null;

    private CourseServiceImpl(){
        this.repository = CourseRepositoryImpl.getRepository();
    }
    public static CourseServiceImpl getService(){
        if(service == null) service = new CourseServiceImpl();
        return service;
    }
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
