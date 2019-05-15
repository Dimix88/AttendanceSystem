package com.dimitri.factory;

import com.dimitri.domain.ImportantDates;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImportantDatesFactoryTest {

    @Test
    public void getImportantDates() {
        String date = "20/11/2019";
        ImportantDates d = ImportantDatesFactory.getImportantDates("20/11/2019","20/11/2019");
        Assert.assertEquals(date, d.getsDate());
        Assert.assertNotNull(d);
    }
}