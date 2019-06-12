package com.dimitri.repository.impl;

import com.dimitri.repository.CleanerIRepository;
import com.dimitri.domain.Cleaner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Repository("CleanerRepository")
public class CleanerIRepositoryImpl implements CleanerIRepository {
    @Autowired
    private static CleanerIRepositoryImpl repository = null;
    private Set<Cleaner> cleaners;

    private CleanerIRepositoryImpl(){
        this.cleaners = new HashSet<>();
    }

    private Cleaner findCleaner(String cleanerID){
        for (Cleaner classes2: this.cleaners){
            if (classes2.getCleanerId().equals(cleanerID))
                return classes2;
        }
        return null;    }
    public static CleanerIRepository getRepository(){
        if(repository == null) repository = new CleanerIRepositoryImpl();
        return repository;
    }

    @Override
    public Cleaner create(Cleaner cleaner) {
        this.cleaners.add(cleaner);
        return cleaner;
    }

    @Override
    public Cleaner update(Cleaner cleaner) {
        Cleaner toDelete = findCleaner(cleaner.getCleanerId());
        if(toDelete != null) {
            this.cleaners.remove(toDelete);
            return create(cleaner);
        }
        return null;
    }

    @Override
    public void delete(String cleanerID) {
        Cleaner class1 = findCleaner(cleanerID);
        if(class1 != null){
            this.cleaners.remove(class1);
        }    }

    @Override
    public Cleaner read(String cleanerID) {
        return findCleaner(cleanerID);
    }
    public Set<Cleaner> getAll(){
        return this.cleaners;
    }
}
