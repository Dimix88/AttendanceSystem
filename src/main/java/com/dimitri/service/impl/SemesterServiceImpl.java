package com.dimitri.service.impl;

import com.dimitri.repository.SemesterIRepository;
//import com.dimitri.repository.impl.SemesterIRepositoryImpl;
import com.dimitri.domain.Semester;
import com.dimitri.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("SemesterServiceImpl")
public class SemesterServiceImpl implements SemesterService {
    public static SemesterService semesterService = null;

    @Autowired
    private SemesterIRepository repository;

    private SemesterServiceImpl(){}

    public static SemesterService getSemesterService(){
        if (semesterService==null)semesterService = new SemesterServiceImpl();
        return semesterService;
    }

    @Override
    public List<Semester> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Semester create(Semester semester) {
        return this.repository.save(semester);
    }

    @Override
    public Semester update(Semester semester) {
        return this.repository.save(semester);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Semester read(String s) {
        Optional<Semester>optionalSemester = this.repository.findById(s);
        return optionalSemester.orElse(null);
    }
}
