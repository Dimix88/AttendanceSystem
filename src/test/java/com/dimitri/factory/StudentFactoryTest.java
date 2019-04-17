package com.dimitri.factory;

import com.dimitri.domain.Student;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentFactoryTest {

    @Test
    public void getStudent() {
        String surname = "Dimitri";
        Student d = StudentFactory.getStudent("Dimitri","Ferus","021773000", "df@gmail.com");
        Assert.assertEquals(surname, d.getStudentName());
        Assert.assertNotNull(d);
    }
}