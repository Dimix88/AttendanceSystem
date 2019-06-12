package com.dimitri.service.impl;

import com.dimitri.repository.CleanerIRepository;
import com.dimitri.repository.impl.CleanerIRepositoryImpl;
import com.dimitri.domain.Cleaner;
import com.dimitri.service.CleanerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service("ServiceImpl4")
public class CleanerServiceImpl implements CleanerService {
    @Autowired
    @Qualifier("CleanerRepository")
    private static CleanerServiceImpl service = null;
    private CleanerIRepository repository = null;

    private CleanerServiceImpl(){
        this.repository = CleanerIRepositoryImpl.getRepository();
    }
    public static CleanerServiceImpl getService(){
        if(service == null) service = new CleanerServiceImpl();
        return service;
    }
    @Override
    public Set<Cleaner> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Cleaner create(Cleaner cleaner) {
        return this.repository.create(cleaner);
    }

    @Override
    public Cleaner update(Cleaner cleaner) {
        return this.repository.update(cleaner);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Cleaner read(String s) {
        return this.repository.read(s);
    }
}
