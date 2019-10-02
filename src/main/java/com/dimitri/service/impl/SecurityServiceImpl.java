package com.dimitri.service.impl;

import com.dimitri.repository.SecurityIRepository;
//import com.dimitri.repository.impl.SecurityIRepositoryImpl;
import com.dimitri.domain.Security;
import com.dimitri.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("SecurityServiceImpl")
public class SecurityServiceImpl implements SecurityService {
    public static SecurityService securityService=null;

    @Autowired
    private SecurityIRepository repository;

    private SecurityServiceImpl(){}

    public static SecurityService getSecurityService(){
        if (securityService==null) securityService= new SecurityServiceImpl();
        return securityService;
    }
    @Override
    public List<Security> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Security create(Security security) {
        return this.repository.save(security);
    }

    @Override
    public Security update(Security security) {
        return this.repository.save(security);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Security read(String s) {
        Optional<Security>optionalSecurity = this.repository.findById(s);
        return optionalSecurity.orElse(null);
    }
}
