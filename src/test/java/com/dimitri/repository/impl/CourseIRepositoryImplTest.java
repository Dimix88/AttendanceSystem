package com.dimitri.repository.impl;

import com.dimitri.repository.CourseIRepository;
import com.dimitri.domain.Course;
import com.dimitri.factory.CourseFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class CourseIRepositoryImplTest {
    @Autowired
    private CourseIRepository repository;
    private Course c1;
    Set<Course>courses = new HashSet<>();


    @Before
    public void setUp() throws Exception {
        this.repository = CourseIRepositoryImpl.getRepository();
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
        Assert.assertSame(4, coursesSet.size());
    }
}