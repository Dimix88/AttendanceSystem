/**package com.dimitri.repository.impl;

import com.dimitri.repository.EnrollIRepository;
import com.dimitri.domain.Enroll;
import com.dimitri.factory.EnrollFactory;
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
public class EnrollIRepositoryImplTest {
    @Autowired
    private EnrollIRepository repository;
    private Enroll c1;
    Set<Enroll> enrolls = new HashSet<>();

    @Before
    public void setUp() throws Exception {

        c1 = EnrollFactory.getEnroll("100","3000","19/06/2019","A");


    }


    @Test
    public void create() {
       Enroll enroll= this.repository.create(this.c1);
        String studentId = "3000";
        System.out.println("In create, created = " + enroll);
        Assert.assertEquals(studentId,enroll.getStudentId());
        Assert.assertNotNull(enroll);
        Assert.assertSame(enroll, this.c1);

    }

    @Test
    public void update() {
        Enroll enroll= this.repository.create(this.c1);
        String studentId = "300";;
        Enroll newStudent = new Enroll.Builder().copy(enroll).studentId(studentId).build();
        this.repository.create(newStudent);
        System.out.println("In update, Will update = " + newStudent);
        Enroll updated = this.repository.update(newStudent);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newStudent.getStudentId(), updated.getStudentId());

    }

    @Test
    public void delete() {
        Enroll enroll= this.repository.create(this.c1);
        this.repository.delete(enroll.getStudentId());
        System.out.println(this.enrolls);

    }

    @Test
    public void read() {
        Enroll enroll= this.repository.create(this.c1);
        System.out.println("In read, studentId = "+enroll.getStudentId() );
        Enroll read = this.repository.read(enroll.getStudentId());
        System.out.println("In read, read = "+ read);
        Assert.assertEquals("3000",repository.read(c1.getStudentId()).getStudentId());

    }


    @Test
    public void getAll() {
        Enroll enroll= this.repository.create(this.c1);
        Set<Enroll> enroller = this.repository.getAll();
        System.out.println("In getAll, all = " + enroller);
        Assert.assertSame(2, enroller.size());
    }



}**/