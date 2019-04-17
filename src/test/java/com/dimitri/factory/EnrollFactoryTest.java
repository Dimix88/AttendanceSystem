package com.dimitri.factory;

import com.dimitri.domain.Enroll;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EnrollFactoryTest {

    @Test
    public void getEnroll() {
        String code = "1234";
        Enroll e = EnrollFactory.getEnroll("1234", "88383", "2019/08/17", "B");
        Assert.assertEquals(code, e.getCourseCode());
        Assert.assertNotNull(e);
    }
}