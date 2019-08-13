package com.dimitri.service.impl;

import com.dimitri.repository.AdminIRepository;
import com.dimitri.repository.impl.AdminIRepositoryImpl;
import com.dimitri.domain.Admin;
import com.dimitri.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("AdminServiceImpl")
public class AdminServiceImpl implements AdminService {
    @Autowired
    @Qualifier("AdminRepository")
    private AdminIRepository repository = null;

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
