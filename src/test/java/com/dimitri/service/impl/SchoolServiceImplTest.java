package com.dimitri.service.impl;

import com.dimitri.repository.SchoolIRepository;
//import com.dimitri.repository.impl.SchoolIRepositoryImpl;
import com.dimitri.domain.School;
import com.dimitri.factory.SchoolFactory;
import com.dimitri.service.SchoolService;
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
public class SchoolServiceImplTest {
    private SchoolService schoolService;
    private SchoolIRepository repository;
    private School c1;

    @Before
    public void setUp() throws Exception {
        this.schoolService = SchoolServiceImpl.getSchoolService();
        c1 = SchoolFactory.getSchool("Helderberg");
        this.schoolService.create(c1);
    }

    @Test
    public void create() {
        School school= SchoolFactory.getSchool("Ladismith");
        String name = "Ladismith";
        Assert.assertEquals(school.getSchoolName(),schoolService.read(school.getSchoolCode()).getSchoolName());
        Assert.assertNotNull(school);
        Assert.assertEquals(name, schoolService.read(school.getSchoolCode()).getSchoolName());
        Assert.assertSame(school, schoolService.read(school.getSchoolCode()));
    }

    @Test
    public void update() {
        String newSchoolName = "Oudtshoorn";
        School newSchool = new School.Builder().copy(c1).schoolName(newSchoolName).build();
        this.schoolService.update(newSchool);
        Assert.assertEquals(newSchool,schoolService.read(c1.getSchoolCode()));
    }

    @Test
    public void delete() {
        School deleteSchool= SchoolFactory.getSchool("Zoar");
        schoolService.create(deleteSchool);
        schoolService.delete(deleteSchool.getSchoolCode());
        School result = schoolService.read(deleteSchool.getSchoolCode());
        Assert.assertFalse(schoolService.getAll().iterator().next().getSchoolName().contains("Zoar"));
        Assert.assertNull(result);
    }

    @Test
    public void read() {
        School read = this.schoolService.create(this.c1);
        Assert.assertEquals(read, schoolService.read(read.getSchoolCode()));
        Assert.assertEquals(read, schoolService.read(c1.getSchoolCode()));
    }


    @Test
    public void getAll() {
        List<School> schoolSet = this.schoolService.getAll();
        System.out.println("In getAll, all = " + schoolSet);
        Assert.assertSame(schoolSet.size(),schoolService.getAll().size());
    }
}