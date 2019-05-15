package com.dimitri.service.impl;

import com.dimitri.Repository.EnrollRepository;
import com.dimitri.Repository.impl.EnrollRepositoryImpl;
import com.dimitri.domain.Enroll;
import com.dimitri.service.EnrollService;

import java.util.Set;

public class EnrollServiceImpl implements EnrollService {
    private static EnrollServiceImpl service = null;
    private EnrollRepository repository = null;

    private EnrollServiceImpl(){
        this.repository = EnrollRepositoryImpl.getRepository();
    }
    public static EnrollServiceImpl getService(){
        if(service == null) service = new EnrollServiceImpl();
        return service;
    }
    @Override
    public Set<Enroll> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Enroll create(Enroll enroll) {
        return this.repository.create(enroll);
    }

    @Override
    public Enroll update(Enroll enroll) {
        return this.repository.update(enroll);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Enroll read(String s) {
        return this.repository.read(s);
    }
}
