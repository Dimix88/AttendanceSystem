package com.dimitri.service.impl;

import com.dimitri.repository.CourseIRepository;
//import com.dimitri.repository.impl.CourseIRepositoryImpl;
import com.dimitri.domain.Course;
import com.dimitri.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("CourseServiceImpl")
public class CourseServiceImpl implements CourseService {
    public static CourseService courseService = null;

    @Autowired
    private CourseIRepository repository;

    private CourseServiceImpl(){}

    public static CourseService getCourseService(){
        if (courseService==null) courseService = new CourseServiceImpl();
        return courseService;
    }
    @Override
    public List<Course> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Course create(Course course) {
        return this.repository.save(course);
    }

    @Override
    public Course update(Course course) {
        return this.repository.save(course);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Course read(String s) {
        Optional<Course>optionalCourse = this.repository.findById(s);
        return optionalCourse.orElse(null);
    }
}
