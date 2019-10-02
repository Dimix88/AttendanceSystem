package com.dimitri.factory;

import com.dimitri.domain.CollegeTimetable;
import org.junit.Assert;
import org.junit.Test;

public class CollegeTimetableFactoryTest {

    @Test
    public void getTimetable() {
        String days = "5";
        CollegeTimetable d = TimetableFactory.getTimetable("09:00","5");
        Assert.assertEquals(days, d.getDay());
        Assert.assertNotNull(d);
    }
}