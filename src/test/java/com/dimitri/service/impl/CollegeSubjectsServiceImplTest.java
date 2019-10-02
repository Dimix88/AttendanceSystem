package com.dimitri.service.impl;

import com.dimitri.repository.SubjectsIRepository;
//import com.dimitri.repository.impl.SubjectsIRepositoryImpl;
import com.dimitri.domain.CollegeSubjects;
import com.dimitri.factory.SubjectsFactory;
import com.dimitri.service.SubjectsService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CollegeSubjectsServiceImplTest {
    private SubjectsService subjectsService;
    private SubjectsIRepository repository;
    private CollegeSubjects c1;

    @Before
    public void setUp() throws Exception {
        this.subjectsService = SubjectsServiceImpl.getSubjectsService();
        c1 = SubjectsFactory.getSubjects("2019","Marketing");
        this.subjectsService.create(c1);
    }

    @Test
    public void create() {
        CollegeSubjects collegeSubjects = SubjectsFactory.getSubjects("2013","Marketing");
        this.subjectsService.create(collegeSubjects);
        String name = "Marketing";
        Assert.assertEquals(collegeSubjects.getSubName(),subjectsService.read(collegeSubjects.getSubjectCode()).getSubName());
        Assert.assertNotNull(collegeSubjects);
        Assert.assertEquals(name, subjectsService.read(collegeSubjects.getSubjectCode()).getSubName());
        Assert.assertSame(collegeSubjects, subjectsService.read(collegeSubjects.getSubjectCode()));
    }

    @Test
    public void update() {
        String newSubjectName = "Texting";
        CollegeSubjects newSubject = new CollegeSubjects.Builder().copy(c1).subName(newSubjectName).build();
        this.subjectsService.update(newSubject);
        Assert.assertEquals(newSubject,subjectsService.read(c1.getSubjectCode()));
    }

    @Test
    public void delete() {
        CollegeSubjects deleteCollegeSubjects = SubjectsFactory.getSubjects("2013","Works");
        subjectsService.create(deleteCollegeSubjects);
        subjectsService.delete(deleteCollegeSubjects.getSubjectCode());
        CollegeSubjects result = subjectsService.read(deleteCollegeSubjects.getSubjectCode());
        Assert.assertFalse(subjectsService.getAll().iterator().next().getSubName().contains("Works"));
        Assert.assertNull(result);
    }

    @Test
    public void read() {
        CollegeSubjects read = this.subjectsService.create(this.c1);
        Assert.assertEquals(read, subjectsService.read(read.getSubjectCode()));
        Assert.assertEquals(read, subjectsService.read(c1.getSubjectCode()));
    }


    @Test
    public void getAll() {
        List<CollegeSubjects> collegeSubjectsSet = this.subjectsService.getAll();
        System.out.println("In getAll, all = " + collegeSubjectsSet);
        Assert.assertSame(collegeSubjectsSet.size(),subjectsService.getAll().size());
    }
}