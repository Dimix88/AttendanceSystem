package com.dimitri.Repository.impl;

import com.dimitri.Repository.AdminRepository;
import com.dimitri.domain.Admin;

import java.util.HashSet;
import java.util.Set;

public class AdminRepositoryImpl implements AdminRepository {
    private static AdminRepositoryImpl repository = null;
    private Set<Admin> admins;

    private AdminRepositoryImpl(){
        this.admins = new HashSet<>();
    }

    private Admin findAdmin(String adminID){
        for (Admin classes2: this.admins){
            if (classes2.getAdminID().equals(adminID))
                return classes2;
        }
        return null;    }
    public static AdminRepository getRepository(){
        if(repository == null) repository = new AdminRepositoryImpl();
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
