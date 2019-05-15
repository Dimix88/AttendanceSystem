package com.dimitri.factory;

import com.dimitri.domain.Notices;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NoticesFactoryTest {

    @Test
    public void getNotices() {
        String notice = "eat";
        Notices d = NoticesFactory.getNotices("eat");
        Assert.assertEquals(notice, d.getNotice());
        Assert.assertNotNull(d);
    }
}