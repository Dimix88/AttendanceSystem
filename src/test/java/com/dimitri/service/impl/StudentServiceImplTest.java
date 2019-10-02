package com.dimitri.service.impl;

import com.dimitri.repository.StudentIRepository;
//import com.dimitri.repository.impl.StudentIRepositoryImpl;
import com.dimitri.domain.Student;
import com.dimitri.factory.StudentFactory;
import com.dimitri.service.StudentService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentServiceImplTest {
    private StudentService studentService;
    private StudentIRepository repository;
    private Student c1;

    @Before
    public void setUp() throws Exception {
        this.studentService = StudentServiceImpl.getStudentService();
        c1 = StudentFactory.getStudent("Dimitri","Ferus","1000000","mm@gmail.com");
        this.studentService.create(c1);
    }

    @Test
    public void create() {
        Student student= StudentFactory.getStudent("Jack","Ferus","1000000","mm@gmail.com");
        studentService.create(student);
        String name = "Jack";
        Assert.assertEquals(student.getStudentName(),studentService.read(student.getStudentId()).getStudentName());
        Assert.assertNotNull(student);
        Assert.assertEquals(name, studentService.read(student.getStudentId()).getStudentName());
        Assert.assertSame(student, studentService.read(student.getStudentId()));
    }

    @Test
    public void update() {
        String newStudentName = "Paul";
        Student newStudent = new Student.Builder().copy(c1).studentName(newStudentName).build();
        this.studentService.update(newStudent);
        Assert.assertEquals(newStudent,studentService.read(c1.getStudentId()));
    }

    @Test
    public void delete() {
        Student deleteStudent= StudentFactory.getStudent("Shaun","Ferus","1000000","mm@gmail.com");
        studentService.create(deleteStudent);
        studentService.delete(deleteStudent.getStudentId());
        Student result = studentService.read(deleteStudent.getStudentId());
        Assert.assertFalse(studentService.getAll().iterator().next().getStudentName().contains("Shaun"));
        Assert.assertNull(result);
    }

    @Test
    public void read() {
        Student read= this.studentService.create(this.c1);
        Assert.assertEquals(read, studentService.read(read.getStudentId()));
        Assert.assertEquals(read, studentService.read(c1.getStudentId()));

    }


    @Test
    public void getAll() {
        List<Student> studentsSet = this.studentService.getAll();
        System.out.println("In getAll, all = " + studentsSet);
        Assert.assertSame(studentsSet.size(),studentService.getAll().size());
    }
}