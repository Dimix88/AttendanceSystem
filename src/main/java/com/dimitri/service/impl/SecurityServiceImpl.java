package com.dimitri.service.impl;

import com.dimitri.Repository.SecurityRepository;
import com.dimitri.Repository.impl.SecurityRepositoryImpl;
import com.dimitri.domain.Security;
import com.dimitri.service.SecurityService;

import java.util.Set;

public class SecurityServiceImpl implements SecurityService {
    private static SecurityServiceImpl service = null;
    private SecurityRepository repository = null;

    private SecurityServiceImpl(){
        this.repository = SecurityRepositoryImpl.getRepository();
    }
    public static SecurityServiceImpl getService(){
        if(service == null) service = new SecurityServiceImpl();
        return service;
    }
    @Override
    public Set<Security> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Security create(Security security) {
        return this.repository.create(security);
    }

    @Override
    public Security update(Security security) {
        return this.repository.update(security);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Security read(String s) {
        return this.repository.read(s);
    }
}
