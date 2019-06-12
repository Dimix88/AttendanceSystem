package com.dimitri.repository.impl;

import com.dimitri.repository.SecurityIRepository;
import com.dimitri.domain.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Repository("SecurityRepository")
public class SecurityIRepositoryImpl implements SecurityIRepository {
    @Autowired
    private static SecurityIRepositoryImpl repository = null;
    private Set<Security> securities;

    private SecurityIRepositoryImpl(){
        this.securities = new HashSet<>();
    }

    private Security findSecurity(String securityID){
        for (Security classes2: this.securities){
            if (classes2.getSecurityId().equals(securityID))
                return classes2;
        }
        return null;    }
    public static SecurityIRepository getRepository(){
        if(repository == null) repository = new SecurityIRepositoryImpl();
        return repository;
    }
    @Override
    public Security create(Security security) {
        this.securities.add(security);
        return security;
    }

    @Override
    public Security update(Security security) {
        Security toDelete = findSecurity(security.getSecurityId());
        if(toDelete != null) {
            this.securities.remove(toDelete);
            return create(security);
        }
        return null;
    }

    @Override
    public void delete(String securityID) {
        Security class1 = findSecurity(securityID);
        if(class1 != null){
            this.securities.remove(class1);
        }    }

    @Override
    public Security read(String securityID) {
        return findSecurity(securityID);
    }
    public Set<Security> getAll(){
        return this.securities;
    }
}
