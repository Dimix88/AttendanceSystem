package com.dimitri.service.impl;

import com.dimitri.repository.SemesterIRepository;
import com.dimitri.repository.impl.SemesterIRepositoryImpl;
import com.dimitri.domain.Semester;
import com.dimitri.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service("ServiceImpl16")
public class SemesterServiceImpl implements SemesterService {
    @Autowired
    @Qualifier("SemesterRepository")
    private static SemesterServiceImpl service = null;
    private SemesterIRepository repository = null;

    private SemesterServiceImpl(){
        this.repository = SemesterIRepositoryImpl.getRepository();
    }
    public static SemesterServiceImpl getService(){
        if(service == null) service = new SemesterServiceImpl();
        return service;
    }
    @Override
    public Set<Semester> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Semester create(Semester semester) {
        return this.repository.create(semester);
    }

    @Override
    public Semester update(Semester semester) {
        return this.repository.update(semester);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Semester read(String s) {
        return this.repository.read(s);
    }
}
