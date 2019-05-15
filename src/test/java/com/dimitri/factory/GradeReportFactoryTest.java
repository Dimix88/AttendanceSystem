package com.dimitri.factory;

import com.dimitri.domain.GradeReport;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GradeReportFactoryTest {

    @Test
    public void getGradeReport() {
        String letter = "A";
        GradeReport d = GradeReportFactory.getGradeReport("A","96");
        Assert.assertEquals(letter, d.getGradeLetter());
        Assert.assertNotNull(d);
    }
}