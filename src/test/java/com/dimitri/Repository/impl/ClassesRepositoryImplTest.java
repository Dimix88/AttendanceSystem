package com.dimitri.Repository.impl;

import com.dimitri.Repository.ClassesRepository;
import com.dimitri.domain.Classes;
import com.dimitri.factory.ClassesFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClassesRepositoryImplTest {

    private ClassesRepository repository;
    private Classes c1;
    Set<Classes>classes = new HashSet<>();

    @Before
    public void setUp() throws Exception {
        this.repository = ClassesRepositoryImpl.getRepository();
        c1 = ClassesFactory.getClasses("111","200","10:00");


    }

    @Test
    public void create() {
        Classes class1= this.repository.create(this.c1);
        String code = "111";
        System.out.println("In create, created = " + class1);
        Assert.assertEquals(code,class1.getCourseCode());
        Assert.assertNotNull(class1);
        Assert.assertSame(class1, this.c1);
    }

    @Test
    public void update() {
        Classes class1= this.repository.create(this.c1);
        String newClasseCode = "133";
        Classes newClass = new Classes.Builder().copy(class1).classCode(newClasseCode).build();
        this.repository.create(class1);
        System.out.println("In update, Will update = " + newClass);
        Classes updated = this.repository.update(newClass);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newClass.getClassCode(), updated.getClassCode());
    }

    @Test
    public void delete() {
        Classes class1= this.repository.create(this.c1);
        this.repository.delete(class1.getClassCode());
        System.out.println(classes);
    }

    @Test
    public void read() {
        Classes class1= this.repository.create(this.c1);
        System.out.println("In read, courseId = "+ class1.getClassCode());
        Classes read = this.repository.read(class1.getClassCode());
        System.out.println("In read, read = "+ read);
        Assert.assertEquals(c1.getClassCode(), this.repository.read(c1.getClassCode()).getClassCode());
    }

    @Test
    public void getAll() {
        Set<Classes> classesSet = this.repository.getAll();
        System.out.println("In getAll, all = " + classesSet);
        Assert.assertSame(1, classesSet.size());
    }
}