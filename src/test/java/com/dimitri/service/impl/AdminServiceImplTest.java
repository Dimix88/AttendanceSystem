package com.dimitri.service.impl;

import com.dimitri.repository.AdminIRepository;
import com.dimitri.repository.impl.AdminIRepositoryImpl;
import com.dimitri.domain.Admin;
import com.dimitri.factory.AdminFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AdminServiceImplTest {
    @Autowired
    private AdminIRepository repository;
    private Admin c1;
    Set<Admin> admins = new HashSet<>();

    @Before
    public void setUp() throws Exception {

        c1 = AdminFactory.getAdmin("2");

    }

    @Test
    public void create() {
        Admin admin= this.repository.create(this.c1);
        String level = "2";
        System.out.println("In create, created = " + admin);
        Assert.assertEquals(level,admin.getAdminLevel());
        Assert.assertNotNull(admin);
        Assert.assertSame(admin, this.c1);
    }

    @Test
    public void update() {
        Admin admin= this.repository.create(this.c1);
        String newID = "133";
        Admin newAdmin = new Admin.Builder().copy(admin).adminID(newID).build();
        this.repository.create(newAdmin);
        System.out.println("In update, Will update = " + newAdmin);
        Admin updated = this.repository.update(newAdmin);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newAdmin.getAdminID(), updated.getAdminID());
    }

    @Test
    public void delete() {
        Admin admin= this.repository.create(this.c1);
        this.repository.delete(admin.getAdminID());
        System.out.println(this.admins);
    }

    @Test
    public void read() {
        Admin admin= this.repository.create(this.c1);
        System.out.println("In read, courseId = "+ admin.getAdminID());
        Admin read = this.repository.read(admin.getAdminID());
        System.out.println("In read, read = "+ read);
        Assert.assertEquals(c1.getAdminID(), this.repository.read(c1.getAdminID()).getAdminID());

    }


    @Test
    public void getAll() {
        Set<Admin> adminSet= this.repository.getAll();
        System.out.println("In getAll, all = " + adminSet);
        Assert.assertSame(1, adminSet.size());
    }
}