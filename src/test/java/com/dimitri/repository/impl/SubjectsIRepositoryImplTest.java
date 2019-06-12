package com.dimitri.repository.impl;

import com.dimitri.repository.SubjectsIRepository;
import com.dimitri.domain.Subjects;
import com.dimitri.factory.SubjectsFactory;
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
public class SubjectsIRepositoryImplTest {
    @Autowired
    private SubjectsIRepository repository;
    private Subjects c1;
    Set<Subjects> subjects = new HashSet<>();

    @Before
    public void setUp() throws Exception {

        c1 = SubjectsFactory.getSubjects("2019","Marketing");

    }

    @Test
    public void create() {
        Subjects subjects= this.repository.create(this.c1);
        String name = "Marketing";
        System.out.println("In create, created = " + subjects);
        Assert.assertEquals(name,subjects.getSubName());
        Assert.assertNotNull(subjects);
        Assert.assertSame(subjects, this.c1);
    }

    @Test
    public void update() {
        Subjects subjects= this.repository.create(this.c1);
        String newSubjectCode = "133";
        Subjects newSubject = new Subjects.Builder().copy(subjects).subjectCode(newSubjectCode).build();
        this.repository.create(newSubject);
        System.out.println("In update, Will update = " + newSubject);
        Subjects updated = this.repository.update(newSubject);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newSubject.getSubjectCode(), updated.getSubjectCode());
    }

    @Test
    public void delete() {
        Subjects subjects= this.repository.create(this.c1);
        this.repository.delete(subjects.getSubjectCode());
        System.out.println(this.subjects);
    }

    @Test
    public void read() {
        Subjects subjects= this.repository.create(this.c1);
        System.out.println("In read, courseId = "+ subjects.getSubjectCode());
        Subjects read = this.repository.read(subjects.getSubjectCode());
        System.out.println("In read, read = "+ read);
        Assert.assertEquals(c1.getSubjectCode(), this.repository.read(c1.getSubjectCode()).getSubjectCode());

    }


    @Test
    public void getAll() {
        Set<Subjects> subjectsSet = this.repository.getAll();
        System.out.println("In getAll, all = " + subjectsSet);
        Assert.assertSame(4, subjectsSet.size());
    }
}