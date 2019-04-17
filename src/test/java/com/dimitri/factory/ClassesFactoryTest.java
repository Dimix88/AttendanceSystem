package com.dimitri.factory;

import com.dimitri.domain.Classes;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClassesFactoryTest {

    @Test
    public void getClasses() {
        String code = "111";
        Classes c = ClassesFactory.getClasses("111", "870202","17:00");
        Assert.assertEquals(code, c.getCourseCode());
        Assert.assertNotNull(c);
    }
}