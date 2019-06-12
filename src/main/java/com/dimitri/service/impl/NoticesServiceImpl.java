package com.dimitri.service.impl;

import com.dimitri.repository.NoticesIRepository;
import com.dimitri.repository.impl.NoticesIRepositoryImpl;
import com.dimitri.domain.Notices;
import com.dimitri.service.NoticesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service("ServiceImpl12")
public class NoticesServiceImpl implements NoticesService {
    @Autowired
    @Qualifier("NoticeRepository")
    private static NoticesServiceImpl service = null;
    private NoticesIRepository repository = null;

    private NoticesServiceImpl(){
        this.repository = NoticesIRepositoryImpl.getRepository();
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
