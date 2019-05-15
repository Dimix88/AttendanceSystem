package com.dimitri.factory;

import com.dimitri.domain.Semester;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SemesterFactoryTest {

    @Test
    public void getSemester() {
        String name = "One";
        Semester b = SemesterFactory.getSemester("2019", "One","15/02/2019","29/05/2019");
        Assert.assertEquals(name, b.getSemesterTerm());
        Assert.assertNotNull(b);
    }
}