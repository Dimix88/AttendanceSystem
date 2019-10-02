package com.dimitri.service.impl;

import com.dimitri.repository.CleanerIRepository;
//import com.dimitri.repository.impl.CleanerIRepositoryImpl;
import com.dimitri.domain.Cleaner;
import com.dimitri.service.CleanerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("CleanerServiceImpl")
public class CleanerServiceImpl implements CleanerService {
    public static CleanerService cleanerService = null;

    @Autowired
    private CleanerIRepository repository;

    private CleanerServiceImpl(){}

    public static CleanerService getCleanerService(){
        if(cleanerService==null)cleanerService = new CleanerServiceImpl();
        return cleanerService;
    }
    @Override
    public List<Cleaner> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Cleaner create(Cleaner cleaner) {
        return this.repository.save(cleaner);
    }

    @Override
    public Cleaner update(Cleaner cleaner) {
        return this.repository.save(cleaner);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Cleaner read(String s) {
        Optional<Cleaner>optionalCleaner = this.repository.findById(s);
        return optionalCleaner.orElse(null);
    }
}
