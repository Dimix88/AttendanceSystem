package com.dimitri.service.impl;

import com.dimitri.repository.AdminIRepository;
//import com.dimitri.repository.impl.AdminIRepositoryImpl;
import com.dimitri.domain.Admin;
import com.dimitri.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("AdminServiceImpl")
public class AdminServiceImpl implements AdminService {
    private static AdminService adminService = null;

    @Autowired
    private AdminIRepository repository;

    private AdminServiceImpl(){}

    public static AdminService getAdminService(){
        if(adminService==null)adminService = new AdminServiceImpl();
        return adminService;
    }

    @Override
    public List<Admin> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Admin create(Admin admin) {
        return this.repository.save(admin);
    }

    @Override
    public Admin update(Admin admin) {
        return this.repository.save(admin);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Admin read(String s) {
        Optional<Admin>optionalAdmin = this.repository.findById(s);
        return optionalAdmin.orElse(null);
    }
}
