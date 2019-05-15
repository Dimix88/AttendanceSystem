package com.dimitri.factory;

import com.dimitri.domain.Address;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressFactoryTest {

    @Test
    public void getAddress() {
        String prov = "Western Cape";
        Address a = AddressFactory.getAddress("22 Fish Street","P.O. Box 112","Cape Town","Western Cape");
        Assert.assertEquals(prov, a.getProvince());
        Assert.assertNotNull(a);
    }
}