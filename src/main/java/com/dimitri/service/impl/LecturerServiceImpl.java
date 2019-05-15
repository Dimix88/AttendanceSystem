package com.dimitri.service.impl;

import com.dimitri.Repository.LecturerRepository;
import com.dimitri.Repository.impl.LecturerRepositoryImpl;
import com.dimitri.domain.Lecturer;
import com.dimitri.service.LecturerService;

import java.util.Set;

public class LecturerServiceImpl implements LecturerService {
    private static LecturerServiceImpl service = null;
    private LecturerRepository repository = null;

    private LecturerServiceImpl(){
        this.repository = LecturerRepositoryImpl.getRepository();
    }
    public static LecturerServiceImpl getService(){
        if(service == null) service = new LecturerServiceImpl();
        return service;
    }
    @Override
    public Set<Lecturer> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Lecturer create(Lecturer lecturer) {
        return this.repository.create(lecturer);
    }

    @Override
    public Lecturer update(Lecturer lecturer) {
        return this.repository.update(lecturer);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Lecturer read(String s) {
        return this.repository.read(s);
    }
}
