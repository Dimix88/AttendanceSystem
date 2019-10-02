package com.dimitri.service.impl;

import com.dimitri.repository.EnrollIRepository;
//import com.dimitri.repository.impl.EnrollIRepositoryImpl;
import com.dimitri.domain.Enroll;
import com.dimitri.service.EnrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("EnrollServiceImpl")
public class EnrollServiceImpl implements EnrollService {
    public static EnrollService enrollService=null;

    @Autowired
    private EnrollIRepository repository;

    private EnrollServiceImpl(){}

    public static EnrollService getEnrollService(){
        if (enrollService==null)enrollService= new EnrollServiceImpl();
        return enrollService;
    }
    @Override
    public List<Enroll> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Enroll create(Enroll enroll) {
        return this.repository.save(enroll);
    }

    @Override
    public Enroll update(Enroll enroll) {
        return this.repository.save(enroll);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Enroll read(String s) {
        Optional<Enroll>optionalEnroll = this.repository.findById(s);
        return optionalEnroll.orElse(null);
    }
}
