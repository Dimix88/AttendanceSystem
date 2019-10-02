/**package com.dimitri.repository.impl;

import com.dimitri.repository.SchoolIRepository;
import com.dimitri.domain.School;
import com.dimitri.factory.SchoolFactory;
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
public class SchoolIRepositoryImplTest {
    @Autowired
    private SchoolIRepository repository;
    private School c1;
    Set<School> schools = new HashSet<>();

    @Before
    public void setUp() throws Exception {

        c1 = SchoolFactory.getSchool("Helderberg");

    }

    @Test
    public void create() {
        School school= this.repository.create(this.c1);
        String name = "Helderberg";
        System.out.println("In create, created = " + school);
        Assert.assertEquals(name,school.getSchoolName());
        Assert.assertNotNull(schools);
        Assert.assertSame(school, this.c1);
    }

    @Test
    public void update() {
        School school= this.repository.create(this.c1);
        String newSchoolCode = "133";
        School newSchool = new School.Builder().copy(school).schoolCode(newSchoolCode).build();
        this.repository.create(newSchool);
        System.out.println("In update, Will update = " + newSchool);
        School updated = this.repository.update(newSchool);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newSchool.getSchoolCode(), updated.getSchoolCode());
    }

    @Test
    public void delete() {
        School school= this.repository.create(this.c1);
        this.repository.delete(school.getSchoolCode());
        System.out.println(this.schools);
    }

    @Test
    public void read() {
        School school= this.repository.create(this.c1);
        System.out.println("In read, courseId = "+school.getSchoolCode());
        School read = this.repository.read(school.getSchoolCode());
        System.out.println("In read, read = "+ read);
        Assert.assertEquals(c1.getSchoolCode(), this.repository.read(c1.getSchoolCode()).getSchoolCode());

    }


    @Test
    public void getAll() {
        Set<School> schoolSet = this.repository.getAll();
        System.out.println("In getAll, all = " + schoolSet);
        Assert.assertSame(4, schoolSet.size());
    }
}**/