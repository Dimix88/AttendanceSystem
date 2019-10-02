/**package com.dimitri.repository.impl;

import com.dimitri.repository.CourseIRepository;
import com.dimitri.domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Repository("CourseRepository")
public class CourseIRepositoryImpl implements CourseIRepository {
    @Autowired
    private static CourseIRepositoryImpl repository = null;
    private Set<Course> courses;

    private CourseIRepositoryImpl(){
        this.courses = new HashSet<>();
    }

    private Course findCourse(String courseId){
        for (Course course: this.courses){
            if (course.getCourseId().equals(courseId))
                return course;
        }
        return null;     }
    public static CourseIRepository getRepository(){
        if(repository == null) repository = new CourseIRepositoryImpl();
        return repository;
    }
    @Override
    public Course create(Course course) {
        this.courses.add(course);
        return course;
    }

    @Override
    public Course update(Course course) {
        Course toDelete = findCourse(course.getCourseId());
        if(toDelete != null) {
            this.courses.remove(toDelete);
            return create(course);
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
**/