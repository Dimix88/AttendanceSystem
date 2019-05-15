package com.dimitri.Repository.impl;

import com.dimitri.Repository.Repository;
import com.dimitri.Repository.StudentRepository;
import com.dimitri.domain.Student;

import java.util.HashSet;
import java.util.Set;

public class StudentRepositoryImpl implements StudentRepository {
    private static StudentRepositoryImpl repository = null;

    private Set<Student> students;

    private StudentRepositoryImpl(){
        this.students = new HashSet<>();
    }

    private Student findStudent(String studentId){
        for (Student student: this.students){
            if (student.getStudentId().equals(studentId))
                return student;
        }
        return null;     }
    public static StudentRepository getRepository(){
        if(repository == null) repository = new StudentRepositoryImpl();
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
