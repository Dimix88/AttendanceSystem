package com.dimitri.factory;

import com.dimitri.domain.Lecturer;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LecturerFactoryTest {

    @Test
    public void getLecturer() {

        String name = "Mark";
        Lecturer lec = LecturerFactory.getLecturer("Mark", "Mayes", "02178783007", "mmayes@gmail.com");
        Assert.assertEquals(name, lec.getFirstName());
        Assert.assertNotNull(lec);
    }
}