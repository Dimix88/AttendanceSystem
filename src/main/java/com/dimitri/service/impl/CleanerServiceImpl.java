package com.dimitri.service.impl;

import com.dimitri.Repository.CleanerRepository;
import com.dimitri.Repository.impl.CleanerRepositoryImpl;
import com.dimitri.domain.Cleaner;
import com.dimitri.service.CleanerService;

import java.util.Set;

public class CleanerServiceImpl implements CleanerService {
    private static CleanerServiceImpl service = null;
    private CleanerRepository repository = null;

    private CleanerServiceImpl(){
        this.repository = CleanerRepositoryImpl.getRepository();
    }
    public static CleanerServiceImpl getService(){
        if(service == null) service = new CleanerServiceImpl();
        return service;
    }
    @Override
    public Set<Cleaner> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Cleaner create(Cleaner cleaner) {
        return this.repository.create(cleaner);
    }

    @Override
    public Cleaner update(Cleaner cleaner) {
        return this.repository.update(cleaner);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Cleaner read(String s) {
        return this.repository.read(s);
    }
}
