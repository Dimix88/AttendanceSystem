package com.dimitri.service.impl;

import com.dimitri.Repository.GradeReportRepository;
import com.dimitri.Repository.impl.GradeReportRepositoryImpl;
import com.dimitri.domain.GradeReport;
import com.dimitri.factory.GradeReportFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class GradeReportServiceImplTest {
    private GradeReportRepository repository;
    private GradeReport c1;
    Set<GradeReport> gradeReports = new HashSet<>();

    @Before
    public void setUp() throws Exception {
        this.repository = GradeReportRepositoryImpl.getRepository();
        c1 = GradeReportFactory.getGradeReport("A","95");

    }

    @Test
    public void create() {
        GradeReport gradeReport= this.repository.create(this.c1);
        String grade = "A";
        System.out.println("In create, created = " + gradeReport);
        Assert.assertEquals(grade,gradeReport.getGradeLetter());
        Assert.assertNotNull(gradeReport);
        Assert.assertSame(gradeReport, this.c1);
    }

    @Test
    public void update() {
        GradeReport gradeReport= this.repository.create(this.c1);
        String newStudentId = "133";
        GradeReport newStudent = new GradeReport.Builder().copy(gradeReport).studentID(newStudentId).build();
        this.repository.create(newStudent);
        System.out.println("In update, Will update = " + newStudent);
        GradeReport updated = this.repository.update(newStudent);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newStudent.getStudentID(), updated.getStudentID());
    }

    @Test
    public void delete() {
        GradeReport gradeReport= this.repository.create(this.c1);
        this.repository.delete(gradeReport.getStudentID());
        System.out.println(this.gradeReports);
    }

    @Test
    public void read() {
        GradeReport gradeReport= this.repository.create(this.c1);
        System.out.println("In read, courseId = "+ gradeReport.getStudentID());
        GradeReport read = this.repository.read(gradeReport.getStudentID());
        System.out.println("In read, read = "+ read);
        Assert.assertEquals(c1.getStudentID(), this.repository.read(c1.getStudentID()).getStudentID());

    }


    @Test
    public void getAll() {
        Set<GradeReport> studentsSet = this.repository.getAll();
        System.out.println("In getAll, all = " + studentsSet);
        Assert.assertSame(1, studentsSet.size());
    }
}