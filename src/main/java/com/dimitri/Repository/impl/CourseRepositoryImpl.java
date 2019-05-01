package com.dimitri.Repository.impl;

import com.dimitri.Repository.CourseRepository;
import com.dimitri.Repository.Repository;
import com.dimitri.domain.Course;

import java.util.HashSet;
import java.util.Set;

public class CourseRepositoryImpl implements CourseRepository {
    private static CourseRepositoryImpl repository = null;
    private Set<Course> courses;

    private CourseRepositoryImpl(){
        this.courses = new HashSet<>();
    }

    private Course findCourse(String courseId){
        for (Course course: this.courses){
            if (course.getCourseId().equals(courseId))
                return course;
        }
        return null;     }
    public static CourseRepository getRepository(){
        if(repository == null) repository = new CourseRepositoryImpl();
        return repository;
    }
    @Override
    public Course create(Course course) {
        this.courses.add(course);
        return course;
    }

    @Override
    public Course update(Course course) {
        if(this.courses.contains(course)){
            this.courses.remove(course);
            this.courses.add(course);
        }
        return course;
    }

    @Override
    public void delete(String courseId) {
        Course course = findCourse(courseId);
        if(course != null){
            this.courses.remove(course);
        }
    }

    @Override
    public Course read(String courseId) {
        return findCourse(courseId);
    }
    public Set<Course> getAll(){
        return this.courses;
    }
}
