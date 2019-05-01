package com.dimitri.Repository.impl;

import com.dimitri.Repository.DepartmentRepository;
import com.dimitri.domain.Department;
import com.dimitri.factory.DepartmentFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class DepartmentRepositoryImplTest {

    private DepartmentRepository repository;
    private Department c1;


    private Department getSavedClass(){
        Set<Department> departments = this.repository.getAll();
        this.repository.create(this.c1);
        return departments.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = DepartmentRepositoryImpl.getRepository();
        c1 = DepartmentFactory.getDepartment("Marketing","UWC");

    }

    @Test
    public void create() {
        Department department= this.repository.create(this.c1);
        String name = "Accounting";
        System.out.println("In create, created = " + department);
        getAll();
        Assert.assertEquals(name,department.getDeptName());
        Assert.assertNotNull(department);
        Assert.assertSame(department, this.c1);
    }

    @Test
    public void update() {
        String newDeptId = "133";
        Department newDept = new Department.Builder().copy(getSavedClass()).deptName(newDeptId).build();
        System.out.println("In update, Will update = " + newDept);
        Department updated = this.repository.update(newDept);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newDept.getDeptName(), updated.getDeptName());
        getAll();
    }

    @Test
    public void delete() {
        Department department = getSavedClass();
        this.repository.delete(department.getDeptCode());
        getAll();
    }

    @Test
    public void read() {
        Department saved = getSavedClass();
        System.out.println("In read, courseId = "+ saved.getDeptCode());
        Department read = this.repository.read(saved.getDeptCode());
        System.out.println("In read, read = "+ read);
        getAll();
        Assert.assertEquals(read, saved);
    }


    @Test
    public void getAll() {
        Set<Department> departments2 = this.repository.getAll();
        System.out.println("In getAll, all = " + departments2);
        Assert.assertSame(1, departments2.size());
    }
}