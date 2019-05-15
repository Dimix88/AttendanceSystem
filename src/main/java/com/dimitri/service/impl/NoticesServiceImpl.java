package com.dimitri.service.impl;

import com.dimitri.Repository.NoticesRepository;
import com.dimitri.Repository.impl.NoticesRepositoryImpl;
import com.dimitri.domain.Notices;
import com.dimitri.service.NoticesService;

import java.util.Set;

public class NoticesServiceImpl implements NoticesService {
    private static NoticesServiceImpl service = null;
    private NoticesRepository repository = null;

    private NoticesServiceImpl(){
        this.repository = NoticesRepositoryImpl.getRepository();
    }
    public static NoticesServiceImpl getService(){
        if(service == null) service = new NoticesServiceImpl();
        return service;
    }
    @Override
    public Set<Notices> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Notices create(Notices notices) {
        return this.repository.create(notices);
    }

    @Override
    public Notices update(Notices notices) {
        return this.repository.update(notices);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Notices read(String s) {
        return this.repository.read(s);
    }
}
