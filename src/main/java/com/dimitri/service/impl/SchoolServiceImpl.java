package com.dimitri.service.impl;

import com.dimitri.Repository.SchoolRepository;
import com.dimitri.Repository.impl.SchoolRepositoryImpl;
import com.dimitri.domain.School;
import com.dimitri.service.SchoolService;

import java.util.Set;

public class SchoolServiceImpl implements SchoolService {
    private static SchoolServiceImpl service = null;
    private SchoolRepository repository = null;

    private SchoolServiceImpl(){
        this.repository = SchoolRepositoryImpl.getRepository();
    }
    public static SchoolServiceImpl getService(){
        if(service == null) service =new SchoolServiceImpl();
        return service;
    }
    @Override
    public School create(School school) {
        return this.repository.create(school);
    }

    @Override
    public School update(School school) {
        return this.repository.update(school);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public School read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<School> getAll() {
        return this.repository.getAll();
    }
}
