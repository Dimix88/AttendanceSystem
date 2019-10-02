package com.dimitri.service.impl;

import com.dimitri.repository.AdminIRepository;
//import com.dimitri.repository.impl.AdminIRepositoryImpl;
import com.dimitri.domain.Admin;
import com.dimitri.factory.AdminFactory;
import com.dimitri.service.AdminService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AdminServiceImplTest {
    private AdminService adminService;
    private AdminIRepository repository;
    private Admin c1;

    @Before
    public void setUp() throws Exception {
        this.adminService = AdminServiceImpl.getAdminService();
        c1 = AdminFactory.getAdmin("2");
        adminService.create(c1);
    }

    @Test
    public void create() {
        Admin admin = AdminFactory.getAdmin("9");
        this.adminService.create(admin);
        String level = "9";
        Assert.assertEquals(admin.getAdminLevel(),adminService.read(admin.getAdminID()).getAdminLevel());
        Assert.assertNotNull(admin);
        Assert.assertEquals(level, adminService.read(admin.getAdminID()).getAdminLevel());
        Assert.assertSame(admin, adminService.read(admin.getAdminID()));
    }

    @Test
    public void update() {
        String newLevel = "10";
        Admin newAdmin = new Admin.Builder().copy(c1).adminLevel(newLevel).build();
        adminService.update(newAdmin);
        Assert.assertEquals(newAdmin,adminService.read(c1.getAdminID()));
    }

    @Test
    public void delete() {
        Admin deleteAdmin = AdminFactory.getAdmin("6");
        adminService.create(deleteAdmin);
        adminService.delete(deleteAdmin.getAdminID());
        Admin result = adminService.read(deleteAdmin.getAdminID());
        Assert.assertFalse(adminService.getAll().iterator().next().getAdminLevel().contains("6"));
        Assert.assertNull(result);
    }

    @Test
    public void read() {
        Admin read = adminService.read(c1.getAdminID());
        Assert.assertEquals(read, adminService.read(read.getAdminID()));
        Assert.assertEquals(read, adminService.read(c1.getAdminID()));
    }


    @Test
    public void getAll() {
        List<Admin> adminList = this.adminService.getAll();
        System.out.println("In getAll, all = " + adminList);
        Assert.assertSame(adminList.size(),adminService.getAll().size());
    }
}