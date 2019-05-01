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


    private Classes getSavedClass(){
        Set<Classes> classes = this.repository.getAll();
        this.repository.create(this.c1);
        return classes.iterator().next();
    }
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
        getAll();
        Assert.assertEquals(code,class1.getCourseCode());
        Assert.assertNotNull(class1);
        Assert.assertSame(class1, this.c1);
    }

    @Test
    public void update() {
        String newClasseCode = "133";
        Classes newClass = new Classes.Builder().copy(getSavedClass()).classCode(newClasseCode).build();
        System.out.println("In update, Will update = " + newClass);
        Classes updated = this.repository.update(newClass);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newClass.getClassCode(), updated.getClassCode());
        getAll();
    }

    @Test
    public void delete() {
        Classes classes1 = getSavedClass();
        this.repository.delete(classes1.getClassCode());
        getAll();
    }

    @Test
    public void read() {
        Classes saved = getSavedClass();
        System.out.println("In read, courseId = "+ saved.getClassCode());
        Classes read = this.repository.read(saved.getClassCode());
        System.out.println("In read, read = "+ read);
        getAll();
        Assert.assertEquals(read, saved);
    }

    @Test
    public void getAll() {
        Set<Classes> classes = this.repository.getAll();
        System.out.println("In getAll, all = " + classes);
        Assert.assertSame(1, classes.size());
    }
}