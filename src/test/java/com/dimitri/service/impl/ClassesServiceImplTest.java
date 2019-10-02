package com.dimitri.service.impl;

import com.dimitri.repository.ClassesIRepository;
//import com.dimitri.repository.impl.ClassesIRepositoryImpl;
import com.dimitri.domain.Classes;
import com.dimitri.factory.ClassesFactory;
import com.dimitri.service.ClassesService;
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
public class ClassesServiceImplTest {
    private ClassesService classesService;
    private ClassesIRepository repository;
    private Classes c1;

    @Before
    public void setUp() throws Exception {
        this.classesService = ClassesServiceImpl.getClassesService();
        c1 = ClassesFactory.getClasses("111","200","10:00");
        classesService.create(c1);

    }

    @Test
    public void create() {
        Classes class1= ClassesFactory.getClasses("111","","");
        this.classesService.create(class1);
        String code = "111";
        Assert.assertEquals(class1.getClassCode(),classesService.read(class1.getLecturerId()).getClassCode());
        Assert.assertNotNull(class1);
        Assert.assertEquals(code, classesService.read(class1.getLecturerId()).getClassCode());
        Assert.assertSame(class1, classesService.read(class1.getLecturerId()));
    }

    @Test
    public void update() {
        String newClassCode = "133";
        Classes newClass = new Classes.Builder().copy(c1).classCode(newClassCode).build();
        this.classesService.update(c1);
        Assert.assertEquals(newClass,classesService.read(c1.getLecturerId()));
    }

    @Test
    public void delete() {
        Classes deleteClass = ClassesFactory.getClasses("444","","");
        classesService.create(deleteClass);
        classesService.delete(deleteClass.getLecturerId());
        Classes result = classesService.read(deleteClass.getLecturerId());
        Assert.assertFalse(classesService.getAll().iterator().next().getClassCode().contains("444"));
        Assert.assertNull(result);
    }

    @Test
    public void read() {
        Classes read= this.classesService.create(this.c1);
        Assert.assertEquals(read, classesService.read(read.getLecturerId()));
        Assert.assertEquals(read, classesService.read(c1.getLecturerId()));
    }

    @Test
    public void getAll() {
        List<Classes> classesSet = this.classesService.getAll();
        System.out.println("In getAll, all = " + classesSet);
        Assert.assertSame(classesSet.size(),classesService.getAll().size());
    }
}