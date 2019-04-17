package com.dimitri.factory;

import com.dimitri.domain.Course;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseFactoryTest {

    @Test
    public void getCourse() {
        String cName = "Accounting 1";
        Course c = CourseFactory.getCourse("Accounting 1");
        Assert.assertEquals(cName, c.getCourseName());
        Assert.assertNotNull(c);
    }
}