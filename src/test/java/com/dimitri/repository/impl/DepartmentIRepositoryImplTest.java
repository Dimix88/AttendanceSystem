/**package com.dimitri.repository.impl;

import com.dimitri.repository.DepartmentIRepository;
import com.dimitri.domain.Department;
import com.dimitri.factory.DepartmentFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class DepartmentIRepositoryImplTest {
    @Autowired
    private DepartmentIRepository repository;
    private Department c1;
    Set<Department>departments = new HashSet<>();

    @Before
    public void setUp() throws Exception {

        c1 = DepartmentFactory.getDepartment("Marketing","UWC");

    }

    @Test
    public void create() {
        Department department= this.repository.create(this.c1);
        String name = "Marketing";
        System.out.println("In create, created = " + department);
        Assert.assertEquals(name,department.getDeptName());
        Assert.assertNotNull(department);
        Assert.assertSame(department, this.c1);
    }

    @Test
    public void update() {
        Department department= this.repository.create(this.c1);
        String newDeptId = "133";
        Department newDept = new Department.Builder().copy(department).deptName(newDeptId).build();
        System.out.println("In update, Will update = " + newDept);
        Department updated = this.repository.update(newDept);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newDept.getDeptName(), updated.getDeptName());
    }

    @Test
    public void delete() {
        Department department= this.repository.create(this.c1);
        this.repository.delete(department.getDeptCode());
        System.out.println(departments);
    }

    @Test
    public void read() {
        Department department= this.repository.create(this.c1);
        System.out.println("In read, courseId = "+ department.getDeptCode());
        Department read = this.repository.read(department.getDeptCode());
        System.out.println("In read, read = "+ read);
        Assert.assertEquals(c1.getDeptCode(), this.repository.read(c1.getDeptCode()).getDeptCode());
    }


    @Test
    public void getAll() {
        Set<Department> departments2 = this.repository.getAll();
        System.out.println("In getAll, all = " + departments2);
        Assert.assertSame(3, departments2.size());
    }
}**/