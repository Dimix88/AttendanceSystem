package com.dimitri.factory;

import com.dimitri.domain.Department;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentFactoryTest {

    @Test
    public void getDepartment() {
        String dptName = "Marketing";
        Department d = DepartmentFactory.getDepartment("Marketing","Informatics");
        Assert.assertSame(dptName, d.getDeptName());
        Assert.assertNotNull(d);
    }
}