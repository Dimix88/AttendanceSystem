package com.dimitri.service.impl;

import com.dimitri.repository.StudentIRepository;
import com.dimitri.repository.impl.StudentIRepositoryImpl;
import com.dimitri.domain.Student;
import com.dimitri.factory.StudentFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashSet;
import java.util.Set;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentServiceImplTest {
    @Autowired
    private StudentIRepository repository;
    private Student c1;
    Set<Student> students = new HashSet<>();

    @Before
    public void setUp() throws Exception {

        c1 = StudentFactory.getStudent("Dimitri","Ferus","1000000","mm@gmail.com");

    }

    @Test
    public void create() {
        Student student= this.repository.create(this.c1);
        String name = "Dimitri";
        System.out.println("In create, created = " + student);
        Assert.assertEquals(name,student.getStudentName());
        Assert.assertNotNull(students);
        Assert.assertSame(student, this.c1);
    }

    @Test
    public void update() {
        Student student= this.repository.create(this.c1);
        String newStudentId = "133";
        Student newStudent = new Student.Builder().copy(student).studentId(newStudentId).build();
        this.repository.create(newStudent);
        System.out.println("In update, Will update = " + newStudent);
        Student updated = this.repository.update(newStudent);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newStudent.getStudentId(), updated.getStudentId());
    }

    @Test
    public void delete() {
        Student student= this.repository.create(this.c1);
        this.repository.delete(student.getStudentId());
        System.out.println(this.students);
    }

    @Test
    public void read() {
        Student student= this.repository.create(this.c1);
        System.out.println("In read, courseId = "+ student.getStudentId());
        Student read = this.repository.read(student.getStudentId());
        System.out.println("In read, read = "+ read);
        Assert.assertEquals(c1.getStudentId(), this.repository.read(c1.getStudentId()).getStudentId());

    }


    @Test
    public void getAll() {
        Set<Student> studentsSet = this.repository.getAll();
        System.out.println("In getAll, all = " + studentsSet);
        Assert.assertSame(1, studentsSet.size());
    }
}