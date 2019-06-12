package com.dimitri.service.impl;

import com.dimitri.repository.StudentIRepository;
import com.dimitri.domain.Student;
import com.dimitri.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("ServiceImpl")
public class StudentServiceImpl implements StudentService {
    @Autowired
    @Qualifier("InMemory")
    private StudentIRepository repository = null;

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
