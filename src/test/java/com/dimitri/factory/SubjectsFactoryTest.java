package com.dimitri.factory;

import com.dimitri.domain.Subjects;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubjectsFactoryTest {

    @Test
    public void getSubjects() {
        String name = "Marketing";
        Subjects d = SubjectsFactory.getSubjects("2019","Marketing");
        Assert.assertEquals(name, d.getSubName());
        Assert.assertNotNull(d);
    }
}