package com.dimitri.service.impl;

import com.dimitri.repository.EnrollIRepository;
//import com.dimitri.repository.impl.EnrollIRepositoryImpl;
import com.dimitri.domain.Enroll;
import com.dimitri.factory.EnrollFactory;
import com.dimitri.service.EnrollService;
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
public class EnrollServiceImplTest {
    private EnrollService enrollService;
    private EnrollIRepository repository;
    private Enroll c1;

    @Before
    public void setUp() throws Exception {
        this.enrollService = EnrollServiceImpl.getEnrollService();
        c1 = EnrollFactory.getEnroll("100","3000","19/06/2019","A");
        enrollService.create(c1);

    }

    @Test
    public void create() {
        Enroll enroll= EnrollFactory.getEnroll("100","211","19/06/2019","A");
        enrollService.create(enroll);
        String studentId = "211";
        Assert.assertEquals(enroll.getStudentId(),enrollService.read(enroll.getStudentId()).getStudentId());
        Assert.assertNotNull(enroll);
        Assert.assertEquals(studentId, enrollService.read(enroll.getStudentId()).getStudentId());
        Assert.assertSame(enroll, enrollService.read(enroll.getStudentId()));

    }

    @Test
    public void update() {
        String studentId = "3";;
        Enroll newStudent = new Enroll.Builder().copy(c1).studentId(studentId).build();
        this.enrollService.update(newStudent);
        enrollService.update(newStudent);
        Assert.assertEquals(newStudent,enrollService.read(c1.getStudentId()));

    }

    @Test
    public void delete() {
        Enroll deleteEnroll= EnrollFactory.getEnroll("233","","","");
        enrollService.create(deleteEnroll);
        enrollService.delete(deleteEnroll.getStudentId());
        Enroll result = enrollService.read(deleteEnroll.getStudentId());
        Assert.assertFalse(enrollService.getAll().iterator().next().getCourseCode().contains("233"));
        Assert.assertNull(result);
    }

    @Test
    public void read() {
        Enroll read= this.enrollService.create(this.c1);
        Assert.assertEquals(read, enrollService.read(read.getStudentId()));
        Assert.assertEquals(read, enrollService.read(c1.getStudentId()));

    }


    @Test
    public void getAll() {
        List<Enroll> enroller = this.enrollService.getAll();
        System.out.println("In getAll, all = " + enroller);
        Assert.assertSame(enroller.size(),enrollService.getAll().size());
    }
}