package com.dimitri.service.impl;

import com.dimitri.Repository.StudentRepository;
import com.dimitri.Repository.impl.StudentRepositoryImpl;
import com.dimitri.domain.Student;
import com.dimitri.service.StudentService;

import java.util.Set;

public class StudentServiceImpl implements StudentService {
    private static StudentServiceImpl service = null;
    private StudentRepository repository = null;

    private StudentServiceImpl(){
        this.repository = StudentRepositoryImpl.getRepository();
    }
    public static StudentServiceImpl getService(){
        if(service == null) service = new StudentServiceImpl();
        return service;
    }
    @Override
    public Set<Student> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Student create(Student student) {
        return this.repository.create(student);
    }

    @Override
    public Student update(Student student) {
        return this.repository.update(student);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Student read(String s) {
        return this.repository.read(s);
    }
}
