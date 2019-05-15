package com.dimitri.service.impl;

import com.dimitri.Repository.SemesterRepository;
import com.dimitri.Repository.impl.SemesterRepositoryImpl;
import com.dimitri.domain.Semester;
import com.dimitri.factory.SemesterFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class SemesterServiceImplTest {

    private SemesterRepository repository;
    private Semester c1;
    Set<Semester> semesters = new HashSet<>();

    @Before
    public void setUp() throws Exception {
        this.repository = SemesterRepositoryImpl.getRepository();
        c1 = SemesterFactory.getSemester("2019","1","15/02/2019","28/03/2019");

    }

    @Test
    public void create() {
        Semester semester= this.repository.create(this.c1);
        String year = "2019";
        System.out.println("In create, created = " + semester);
        Assert.assertEquals(year,semester.getSemesterYear());
        Assert.assertNotNull(semesters);
        Assert.assertSame(semester, this.c1);
    }

    @Test
    public void update() {
        Semester semester= this.repository.create(this.c1);
        String newSemesterCode = "133";
        Semester newSemester = new Semester.Builder().copy(semester).semesterCode(newSemesterCode).build();
        this.repository.create(newSemester);
        System.out.println("In update, Will update = " + newSemester);
        Semester updated = this.repository.update(newSemester);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newSemester.getSemesterCode(), updated.getSemesterCode());
    }

    @Test
    public void delete() {
        Semester semester= this.repository.create(this.c1);
        this.repository.delete(semester.getSemesterCode());
        System.out.println(this.semesters);
    }

    @Test
    public void read() {
        Semester semester= this.repository.create(this.c1);
        System.out.println("In read, courseId = "+ semester.getSemesterCode());
        Semester read = this.repository.read(semester.getSemesterCode());
        System.out.println("In read, read = "+ read);
        Assert.assertEquals(c1.getSemesterCode(), this.repository.read(c1.getSemesterCode()).getSemesterCode());

    }


    @Test
    public void getAll() {
        Set<Semester> semesterSet = this.repository.getAll();
        System.out.println("In getAll, all = " + semesterSet);
        Assert.assertSame(1, semesterSet.size());
    }
}