package com.dimitri.service.impl;

import com.dimitri.repository.StudentIRepository;
import com.dimitri.domain.Student;
import com.dimitri.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service("StudentServiceImpl")
public class StudentServiceImpl implements StudentService {
    public static StudentService studentService = null;

    @Autowired
    private StudentIRepository repository;

    private StudentServiceImpl(){}

    public static StudentService getStudentService(){
        if (studentService==null)studentService = new StudentServiceImpl();
        return studentService;
    }
    @Override
    public List<Student> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Student create(Student student) {
        return this.repository.save(student);
    }

    @Override
    public Student update(Student student) {
        return this.repository.save(student);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Student read(String s) {
        Optional<Student>optionalStudent = this.repository.findById(s);
        return optionalStudent.orElse(null);
    }
}
