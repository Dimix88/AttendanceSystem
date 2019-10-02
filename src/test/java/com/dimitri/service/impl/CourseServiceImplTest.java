package com.dimitri.service.impl;

import com.dimitri.repository.CourseIRepository;
//import com.dimitri.repository.impl.CourseIRepositoryImpl;
import com.dimitri.domain.Course;
import com.dimitri.factory.CourseFactory;
import com.dimitri.service.CourseService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CourseServiceImplTest {
    private CourseService courseService;
    private CourseIRepository repository;
    private Course c1;


    @Before
    public void setUp() throws Exception {
        this.courseService = CourseServiceImpl.getCourseService();
        c1 = CourseFactory.getCourse("Accounting");
        courseService.create(c1);
    }
    @Test
    public void create() {
        Course course= CourseFactory.getCourse("Maths");
        courseService.create(course);
        String name = "Maths";
        Assert.assertEquals(course.getCourseName(),courseService.read(course.getCourseId()).getCourseName());
        Assert.assertNotNull(course);
        Assert.assertEquals(name, courseService.read(course.getCourseId()).getCourseName());
        Assert.assertSame(course, courseService.read(course.getCourseId()));
    }

    @Test
    public void update() {
        String newCourseName = "Science";
        Course newCourse = new Course.Builder().copy(c1).courseId(newCourseName).build();
        this.courseService.update(newCourse);
        Assert.assertEquals(newCourse,courseService.read(c1.getCourseId()));
    }

    @Test
    public void delete() {
        Course deleteCourse= CourseFactory.getCourse("Art");
        courseService.create(deleteCourse);
        courseService.delete(deleteCourse.getCourseId());
        Course result = courseService.read(deleteCourse.getCourseId());
        Assert.assertFalse(courseService.getAll().iterator().next().getCourseName().contains("Art"));
        Assert.assertNull(result);
    }

    @Test
    public void read() {
        Course read= this.courseService.create(this.c1);
        Assert.assertEquals(read, courseService.read(read.getCourseId()));
        Assert.assertEquals(read, courseService.read(c1.getCourseId()));
    }


    @Test
    public void getAll() {
        List<Course> coursesSet = this.courseService.getAll();
        System.out.println("In getAll, all = " + coursesSet);
        Assert.assertSame(coursesSet.size(),courseService.getAll().size());
    }
}