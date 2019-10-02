package com.dimitri.service.impl;

import com.dimitri.repository.SemesterIRepository;
//import com.dimitri.repository.impl.SemesterIRepositoryImpl;
import com.dimitri.domain.Semester;
import com.dimitri.factory.SemesterFactory;
import com.dimitri.service.SemesterService;
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
public class SemesterServiceImplTest {
    private SemesterService semesterService;
    private SemesterIRepository repository;
    private Semester c1;

    @Before
    public void setUp() throws Exception {
        this.semesterService = SemesterServiceImpl.getSemesterService();
        c1 = SemesterFactory.getSemester("2019","1","15/02/2019","28/03/2019");
        this.semesterService.create(c1);
    }

    @Test
    public void create() {
        Semester semester= SemesterFactory.getSemester("2020","1","15/02/2019","28/03/2019");
        this.semesterService.create(semester);
        String year = "2020";
        Assert.assertEquals(semester.getSemesterYear(),semesterService.read(semester.getSemesterCode()).getSemesterYear());
        Assert.assertNotNull(semester);
        Assert.assertEquals(year, semesterService.read(semester.getSemesterCode()).getSemesterYear());
        Assert.assertSame(semester, semesterService.read(semester.getSemesterCode()));
    }

    @Test
    public void update() {
        String newSemesterYear = "2024";
        Semester newSemester = new Semester.Builder().copy(c1).semesterYear(newSemesterYear).build();
        this.semesterService.update(newSemester);
        Assert.assertEquals(newSemester,semesterService.read(c1.getSemesterYear()));
    }

    @Test
    public void delete() {
        Semester deleteSemester= SemesterFactory.getSemester("1996","1","15/02/2019","28/03/2019");
        semesterService.create(deleteSemester);
        semesterService.delete(deleteSemester.getSemesterCode());
        Semester result = semesterService.read(deleteSemester.getSemesterCode());
        Assert.assertFalse(semesterService.getAll().iterator().next().getSemesterYear().contains("1996"));
        Assert.assertNull(result);
    }

    @Test
    public void read() {
        Semester read = this.semesterService.create(this.c1);
        Assert.assertEquals(read, semesterService.read(read.getSemesterCode()));
        Assert.assertEquals(read, semesterService.read(c1.getSemesterCode()));
    }


    @Test
    public void getAll() {
        List<Semester> semesterSet = this.semesterService.getAll();
        System.out.println("In getAll, all = " + semesterSet);
        Assert.assertSame(semesterSet.size(),semesterService.getAll().size());
    }
}