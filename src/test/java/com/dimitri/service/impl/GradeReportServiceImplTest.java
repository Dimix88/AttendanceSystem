package com.dimitri.service.impl;

import com.dimitri.repository.GradeReportIRepository;
//import com.dimitri.repository.impl.GradeReportIRepositoryImpl;
import com.dimitri.domain.GradeReport;
import com.dimitri.factory.GradeReportFactory;
import com.dimitri.service.GradeReportService;
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
public class GradeReportServiceImplTest {
    private GradeReportService gradeReportService;
    private GradeReportIRepository repository;
    private GradeReport c1;

    @Before
    public void setUp() throws Exception {
        this.gradeReportService = GradeReportServiceImpl.getGradeReportService();
        c1 = GradeReportFactory.getGradeReport("A","95");
        gradeReportService.create(c1);
    }

    @Test
    public void create() {
        GradeReport gradeReport= GradeReportFactory.getGradeReport("B","76");
        gradeReportService.create(gradeReport);
        String grade = "B";
        Assert.assertEquals(gradeReport.getStudentID(),gradeReportService.read(gradeReport.getStudentID()).getGradeLetter());
        Assert.assertNotNull(gradeReport);
        Assert.assertEquals(grade, gradeReportService.read(gradeReport.getStudentID()).getGradeLetter());
        Assert.assertSame(gradeReport, gradeReportService.read(gradeReport.getStudentID()));
    }

    @Test
    public void update() {
        String newGradeLetter = "C";
        GradeReport newStudent = new GradeReport.Builder().copy(c1).studentID(newGradeLetter).build();
        this.gradeReportService.update(newStudent);
        Assert.assertEquals(newStudent,gradeReportService.read(c1.getStudentID()));
    }

    @Test
    public void delete() {
        GradeReport deleteGradeReport= GradeReportFactory.getGradeReport("D","50");
        gradeReportService.create(deleteGradeReport);
        gradeReportService.delete(deleteGradeReport.getStudentID());
        GradeReport result = gradeReportService.read(deleteGradeReport.getStudentID());
        Assert.assertFalse(gradeReportService.getAll().iterator().next().getGradeLetter().contains("D"));
        Assert.assertNull(result);
    }

    @Test
    public void read() {
        GradeReport read = this.gradeReportService.create(this.c1);
        Assert.assertEquals(read, gradeReportService.read(read.getStudentID()));
        Assert.assertEquals(read, gradeReportService.read(c1.getStudentID()));

    }


    @Test
    public void getAll() {
        List<GradeReport> studentsSet = this.gradeReportService.getAll();
        System.out.println("In getAll, all = " + studentsSet);
        Assert.assertSame(studentsSet.size(),gradeReportService.getAll().size());
    }
}