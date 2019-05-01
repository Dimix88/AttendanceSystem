package com.dimitri.Repository.impl;

import com.dimitri.Repository.StudentRepository;
import com.dimitri.domain.Student;
import com.dimitri.factory.StudentFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class StudentRepositoryImplTest {


    private StudentRepository repository;
    private Student c1;


    private Student getSavedClass(){
        Set<Student> classes = this.repository.getAll();
        this.repository.create(this.c1);
        return classes.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = StudentRepositoryImpl.getRepository();
        c1 = StudentFactory.getStudent("Dimitri","Ferus","1000000","mm@gmail.com");

    }

    @Test
    public void create() {
        Student student= this.repository.create(this.c1);
        String name = "Dimitri";
        System.out.println("In create, created = " + student);
        getAll();
        Assert.assertEquals(name,student.getStudentName());
        Assert.assertNotNull(student);
        Assert.assertSame(student, this.c1);
    }

    @Test
    public void update() {
        String newStudentId = "133";
        Student newStudent = new Student.Builder().copy(getSavedClass()).studentId(newStudentId).build();
        System.out.println("In update, Will update = " + newStudent);
        Student updated = this.repository.update(newStudent);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newStudent.getStudentId(), updated.getStudentId());
        getAll();
    }

    @Test
    public void delete() {
        Student student = getSavedClass();
        this.repository.delete(student.getStudentId());
        getAll();
    }

    @Test
    public void read() {
        Student saved = getSavedClass();
        System.out.println("In read, courseId = "+ saved.getStudentId());
        Student read = this.repository.read(saved.getStudentId());
        System.out.println("In read, read = "+ read);
        getAll();
        Assert.assertEquals(read, saved);

    }


    @Test
    public void getAll() {
        Set<Student> students = this.repository.getAll();
        System.out.println("In getAll, all = " + students);
        Assert.assertSame(1, students.size());
    }
}