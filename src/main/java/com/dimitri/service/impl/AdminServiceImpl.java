package com.dimitri.service.impl;

import com.dimitri.Repository.AdminRepository;
import com.dimitri.Repository.impl.AdminRepositoryImpl;
import com.dimitri.domain.Admin;
import com.dimitri.service.AdminService;

import java.util.Set;

public class AdminServiceImpl implements AdminService {
    private static AdminServiceImpl service = null;
    private AdminRepository repository = null;

    private AdminServiceImpl(){
        this.repository = AdminRepositoryImpl.getRepository();
    }
    public static AdminServiceImpl getService(){
        if(service == null) service = new AdminServiceImpl();
        return service;
    }
    @Override
    public Set<Admin> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Admin create(Admin admin) {
        return this.repository.create(admin);
    }

    @Override
    public Admin update(Admin admin) {
        return this.repository.update(admin);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Admin read(String s) {
        return this.repository.read(s);
    }
}
