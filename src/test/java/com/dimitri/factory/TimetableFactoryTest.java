package com.dimitri.factory;

import com.dimitri.domain.Timetable;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TimetableFactoryTest {

    @Test
    public void getTimetable() {
        String days = "5";
        Timetable d = TimetableFactory.getTimetable("09:00","5");
        Assert.assertEquals(days, d.getDay());
        Assert.assertNotNull(d);
    }
}