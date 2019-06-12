package com.dimitri.service.impl;

import com.dimitri.repository.LecturerIRepository;
import com.dimitri.repository.impl.LecturerIRepositoryImpl;
import com.dimitri.domain.Lecturer;
import com.dimitri.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service("ServiceImpl10")
public class LecturerServiceImpl implements LecturerService {
    @Autowired
    @Qualifier("LecturerRepository")
    private static LecturerServiceImpl service = null;
    private LecturerIRepository repository = null;

    private LecturerServiceImpl(){
        this.repository = LecturerIRepositoryImpl.getRepository();
    }
    public static LecturerServiceImpl getService(){
        if(service == null) service = new LecturerServiceImpl();
        return service;
    }
    @Override
    public Set<Lecturer> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Lecturer create(Lecturer lecturer) {
        return this.repository.create(lecturer);
    }

    @Override
    public Lecturer update(Lecturer lecturer) {
        return this.repository.update(lecturer);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Lecturer read(String s) {
        return this.repository.read(s);
    }
}
