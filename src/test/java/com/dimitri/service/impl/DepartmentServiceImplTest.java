package com.dimitri.service.impl;

import com.dimitri.repository.DepartmentIRepository;
//import com.dimitri.repository.impl.DepartmentIRepositoryImpl;
import com.dimitri.domain.Department;
import com.dimitri.factory.DepartmentFactory;
import com.dimitri.service.DepartmentService;
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
public class DepartmentServiceImplTest {
    private DepartmentService departmentService;
    private DepartmentIRepository repository;
    private Department c1;

    @Before
    public void setUp() throws Exception {
        this.departmentService = DepartmentServiceImpl.getDepartmentService();
        c1 = DepartmentFactory.getDepartment("Marketing","UWC");
        departmentService.create(c1);
    }

    @Test
    public void create() {
        Department department= DepartmentFactory.getDepartment("Marketing","");
        departmentService.create(department);
        String name = "Marketing";
        Assert.assertEquals(department.getDeptName(),departmentService.read(department.getDeptCode()).getDeptName());
        Assert.assertNotNull(department);
        Assert.assertEquals(name, departmentService.read(department.getDeptCode()).getDeptName());
        Assert.assertSame(department, departmentService.read(department.getDeptCode()));
    }

    @Test
    public void update() { ;
        String newDeptName = "Sales";
        Department newDept = new Department.Builder().copy(c1).deptName(newDeptName).build();
        departmentService.update(newDept);
        Assert.assertEquals(newDept,departmentService.read(c1.getDeptCode()));
    }

    @Test
    public void delete() {
        Department deleteDepartment= DepartmentFactory.getDepartment("IT","");
        departmentService.create(deleteDepartment);
        departmentService.delete(deleteDepartment.getDeptCode());
        Department result = departmentService.read(deleteDepartment.getDeptCode());
        Assert.assertFalse(departmentService.getAll().iterator().next().getDeptName().contains("IT"));
        Assert.assertNull(result);
    }

    @Test
    public void read() {
        Department read= this.departmentService.create(this.c1);
        Assert.assertEquals(read, departmentService.read(read.getDeptCode()));
        Assert.assertEquals(read, departmentService.read(c1.getDeptCode()));
    }


    @Test
    public void getAll() {
        List<Department> departments2 = this.departmentService.getAll();
        System.out.println("In getAll, all = " + departments2);
        Assert.assertSame(departments2.size(),departmentService.getAll().size());
    }
}