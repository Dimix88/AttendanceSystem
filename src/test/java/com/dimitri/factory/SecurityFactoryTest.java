package com.dimitri.factory;

import com.dimitri.domain.Security;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SecurityFactoryTest {

    @Test
    public void getSecurity() {
        String surname = "Dimitri";
        Security d = SecurityFactory.getSecurity("Dimitri","Ferus","021773000", "df@gmail.com");
        Assert.assertEquals(surname, d.getSecurityName());
        Assert.assertNotNull(d);
    }
}