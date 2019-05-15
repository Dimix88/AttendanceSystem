package com.dimitri.Repository.impl;

import com.dimitri.Repository.CourseRepository;
import com.dimitri.domain.Course;
import com.dimitri.domain.Student;
import com.dimitri.factory.CourseFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class CourseRepositoryImplTest {

    private CourseRepository repository;
    private Course c1;
    Set<Course>courses = new HashSet<>();


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
        Assert.assertEquals(name,course.getCourseName());
        Assert.assertNotNull(course);
        Assert.assertSame(course, this.c1);
    }

    @Test
    public void update() {
        Course course= this.repository.create(this.c1);
        String newCourseId = "133";
        Course newCourse = new Course.Builder().copy(course).courseId(newCourseId).build();
        this.repository.create(newCourse);
        System.out.println("In update, Will update = " + newCourse);
        Course updated = this.repository.update(newCourse);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newCourse.getCourseId(), updated.getCourseId());
    }

    @Test
    public void delete() {
        Course course= this.repository.create(this.c1);
        this.repository.delete(course.getCourseId());
        System.out.println(courses);
    }

    @Test
    public void read() {
        Course course= this.repository.create(this.c1);
        System.out.println("In read, courseId = "+ course.getCourseId());
        Course read = this.repository.read(course.getCourseId());
        System.out.println("In read, read = "+ read);
        Assert.assertEquals(c1.getCourseId(), this.repository.read(c1.getCourseId()).getCourseId());
    }


    @Test
    public void getAll() {
        Set<Course> coursesSet = this.repository.getAll();
        System.out.println("In getAll, all = " + coursesSet);
        Assert.assertSame(1, coursesSet.size());
    }
}