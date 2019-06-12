package com.dimitri.service.impl;

import com.dimitri.repository.CourseIRepository;
import com.dimitri.repository.impl.CourseIRepositoryImpl;
import com.dimitri.domain.Course;
import com.dimitri.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service("ServiceImpl5")
public class CourseServiceImpl implements CourseService {
    @Autowired
    @Qualifier("CourseRepository")
    private static CourseServiceImpl service = null;
    private CourseIRepository repository = null;

    private CourseServiceImpl(){
        this.repository = CourseIRepositoryImpl.getRepository();
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
