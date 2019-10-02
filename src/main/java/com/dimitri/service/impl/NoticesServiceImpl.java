package com.dimitri.service.impl;

import com.dimitri.repository.NoticesIRepository;
//import com.dimitri.repository.impl.NoticesIRepositoryImpl;
import com.dimitri.domain.Notices;
import com.dimitri.service.NoticesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("NoticeServiceImpl")
public class NoticesServiceImpl implements NoticesService {
    public static NoticesService noticesService = null;

    @Autowired
    private NoticesIRepository repository;

    private NoticesServiceImpl(){}

    public static NoticesService getNoticesService(){
        if (noticesService==null)noticesService = new NoticesServiceImpl();
        return noticesService;
    }
    @Override
    public List<Notices> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Notices create(Notices notices) {
        return this.repository.save(notices);
    }

    @Override
    public Notices update(Notices notices) {
        return this.repository.save(notices);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Notices read(String s) {
        Optional<Notices>optionalNotices = this.repository.findById(s);
        return optionalNotices.orElse(null);
    }
}
