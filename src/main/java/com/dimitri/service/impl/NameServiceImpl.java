package com.dimitri.service.impl;

import com.dimitri.Repository.NameRepository;
import com.dimitri.Repository.impl.NameRepositoryImpl;
import com.dimitri.domain.Name;
import com.dimitri.service.NameService;

import java.util.Set;

public class NameServiceImpl implements NameService {
    private static NameServiceImpl service = null;
    private NameRepository repository = null;

    private NameServiceImpl(){
        this.repository = NameRepositoryImpl.getRepository();
    }
    public static NameServiceImpl getService(){
        if(service == null) service = new NameServiceImpl();
        return service;
    }
    @Override
    public Set<Name> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Name create(Name name) {
        return this.repository.create(name);
    }

    @Override
    public Name update(Name name) {
        return this.repository.update(name);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Name read(String s) {
        return this.repository.read(s);
    }
}
