package com.dimitri.factory;

import com.dimitri.domain.Admin;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdminFactoryTest {

    @Test
    public void getAdmin() {
        String level = "4";
        Admin a = AdminFactory.getAdmin("4");
        Assert.assertEquals(level, a.getAdminLevel());
        Assert.assertNotNull(a);
    }
}