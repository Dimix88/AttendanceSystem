package com.dimitri.repository.impl;

import com.dimitri.repository.StudentIRepository;
import com.dimitri.domain.Student;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;


@Repository("InMemory")
public class StudentIRepositoryImpl implements StudentIRepository {
    @Autowired
    private static StudentIRepositoryImpl repository = null;

    private Set<Student> students;

    private StudentIRepositoryImpl(){
        this.students = new HashSet<>();
    }

    private Student findStudent(String studentId){
        for (Student student: this.students){
            if (student.getStudentId().equals(studentId))
                return student;
        }
        return null;     }
    public static StudentIRepository getRepository(){
        if(repository == null) repository = new StudentIRepositoryImpl();
        return repository;
    }
    @Override
    public Student create(Student student) {
        this.students.add(student);
        return student;

    }

    @Override
    public Student update(Student student) {
        Student toDelete = findStudent(student.getStudentId());
        if(toDelete != null) {
            this.students.remove(toDelete);
            return create(student);
        }
        return null;
    }

    @Override
    public void delete(String studentId) {
        Student class1 = findStudent(studentId);
        if(class1 != null){
            this.students.remove(class1);
        }
    }

    @Override
    public Student read(final String studentId) {
        return findStudent(studentId);
    }

    public Set<Student> getAll(){
        return this.students;
    }
}
