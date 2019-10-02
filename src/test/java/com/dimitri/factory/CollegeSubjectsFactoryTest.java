package com.dimitri.factory;

import com.dimitri.domain.CollegeSubjects;
import org.junit.Assert;
import org.junit.Test;

public class CollegeSubjectsFactoryTest {

    @Test
    public void getSubjects() {
        String name = "Marketing";
        CollegeSubjects d = SubjectsFactory.getSubjects("2019","Marketing");
        Assert.assertEquals(name, d.getSubName());
        Assert.assertNotNull(d);
    }
}