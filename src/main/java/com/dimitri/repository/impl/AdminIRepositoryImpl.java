package com.dimitri.repository.impl;

import com.dimitri.repository.AdminIRepository;
import com.dimitri.domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Repository("AdminRepository")
public class AdminIRepositoryImpl implements AdminIRepository {
    @Autowired
    private static AdminIRepositoryImpl repository = null;
    private Set<Admin> admins;

    private AdminIRepositoryImpl(){
        this.admins = new HashSet<>();
    }

    private Admin findAdmin(String adminID){
        for (Admin classes2: this.admins){
            if (classes2.getAdminID().equals(adminID))
                return classes2;
        }
        return null;    }
    public static AdminIRepository getRepository(){
        if(repository == null) repository = new AdminIRepositoryImpl();
        return repository;
    }
    @Override
    public Admin create(Admin admin) {
        this.admins.add(admin);
        return admin;
    }

    @Override
    public Admin update(Admin admin) {
        Admin toDelete = findAdmin(admin.getAdminID());
        if(toDelete != null) {
            this.admins.remove(toDelete);
            return create(admin);
        }
        return null;
    }

    @Override
    public void delete(String adminID) {
        Admin class1 = findAdmin(adminID);
        if(class1 != null){
            this.admins.remove(class1);
        }    }

    @Override
    public Admin read(String adminID) {
        return findAdmin(adminID);
    }
    public Set<Admin> getAll(){
        return this.admins;
    }
}
