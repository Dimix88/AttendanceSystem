package com.dimitri.service.impl;

import com.dimitri.Repository.SemesterRepository;
import com.dimitri.Repository.impl.SemesterRepositoryImpl;
import com.dimitri.domain.Semester;
import com.dimitri.service.SemesterService;

import java.util.Set;

public class SemesterServiceImpl implements SemesterService {
    private static SemesterServiceImpl service = null;
    private SemesterRepository repository = null;

    private SemesterServiceImpl(){
        this.repository = SemesterRepositoryImpl.getRepository();
    }
    public static SemesterServiceImpl getService(){
        if(service == null) service = new SemesterServiceImpl();
        return service;
    }
    @Override
    public Set<Semester> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Semester create(Semester semester) {
        return this.repository.create(semester);
    }

    @Override
    public Semester update(Semester semester) {
        return this.repository.update(semester);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Semester read(String s) {
        return this.repository.read(s);
    }
}
