package com.dimitri.Repository.impl;

import com.dimitri.Repository.CourseRepository;
import com.dimitri.domain.Course;
import com.dimitri.domain.Student;
import com.dimitri.factory.CourseFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class CourseRepositoryImplTest {

    private CourseRepository repository;
    private Course c1;


    private Course getSavedClass(){
        Set<Course> courses = this.repository.getAll();
        this.repository.create(this.c1);
        return courses.iterator().next();
    }
    @Before
    public void setUp() throws Exception {
        this.repository = CourseRepositoryImpl.getRepository();
        c1 = CourseFactory.getCourse("Accounting");

    }
    @Test
    public void create() {
        Course course= this.repository.create(this.c1);
        String name = "Accounting";
        System.out.println("In create, created = " + course);
        getAll();
        Assert.assertEquals(name,course.getCourseName());
        Assert.assertNotNull(course);
        Assert.assertSame(course, this.c1);
    }

    @Test
    public void update() {
        String newCourseId = "133";
        Course newCourse = new Course.Builder().copy(getSavedClass()).courseId(newCourseId).build();
        System.out.println("In update, Will update = " + newCourse);
        Course updated = this.repository.update(newCourse);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newCourse.getCourseId(), updated.getCourseId());
        getAll();
    }

    @Test
    public void delete() {
        Course course = getSavedClass();
        this.repository.delete(course.getCourseId());
        getAll();
    }

    @Test
    public void read() {
        Course saved = getSavedClass();
        System.out.println("In read, courseId = "+ saved.getCourseId());
        Course read = this.repository.read(saved.getCourseId());
        System.out.println("In read, read = "+ read);
        getAll();
        Assert.assertEquals(read, saved);
    }


    @Test
    public void getAll() {
        Set<Course> courses = this.repository.getAll();
        System.out.println("In getAll, all = " + courses);
        Assert.assertSame(1, courses.size());
    }
}