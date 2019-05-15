package com.dimitri.factory;

import com.dimitri.domain.Name;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NameFactoryTest {

    @Test
    public void getName() {
        String name = "Mike";
        Name b = NameFactory.getName("Mike", "James","Larry");
        Assert.assertEquals(name, b.getFirstname());
        Assert.assertNotNull(b);
    }
}