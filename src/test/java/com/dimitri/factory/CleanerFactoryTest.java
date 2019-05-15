package com.dimitri.factory;

import com.dimitri.domain.Cleaner;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CleanerFactoryTest {

    @Test
    public void getCleaner() {
        String name = "Dimitri";
        Cleaner a = CleanerFactory.getCleaner("Dimitri","Ferus","021773000", "df@gmail.com");
        Assert.assertEquals(name, a.getCleanerName());
        Assert.assertNotNull(a);
    }
}