package com.dimitri.service.impl;

import com.dimitri.Repository.ClassesRepository;
import com.dimitri.Repository.impl.ClassesRepositoryImpl;
import com.dimitri.domain.Classes;
import com.dimitri.service.ClassesService;

import java.util.Set;

public class ClassesServiceImpl implements ClassesService {
    private static ClassesServiceImpl service = null;
    private ClassesRepository repository = null;

    private ClassesServiceImpl(){
        this.repository = ClassesRepositoryImpl.getRepository();
    }
    public static ClassesServiceImpl getService(){
        if(service==null) service = new ClassesServiceImpl();
        return service;
    }
    @Override
    public Set<Classes> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Classes create(Classes classes) {
        return this.repository.create(classes);
    }

    @Override
    public Classes update(Classes classes) {
        return this.repository.update(classes);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Classes read(String s) {
        return this.repository.read(s);
    }
}
