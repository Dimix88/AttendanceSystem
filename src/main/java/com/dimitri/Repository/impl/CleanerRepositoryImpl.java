package com.dimitri.Repository.impl;

import com.dimitri.Repository.CleanerRepository;
import com.dimitri.domain.Cleaner;

import java.util.HashSet;
import java.util.Set;

public class CleanerRepositoryImpl implements CleanerRepository {
    private static CleanerRepositoryImpl repository = null;
    private Set<Cleaner> cleaners;

    private CleanerRepositoryImpl(){
        this.cleaners = new HashSet<>();
    }

    private Cleaner findCleaner(String cleanerID){
        for (Cleaner classes2: this.cleaners){
            if (classes2.getCleanerId().equals(cleanerID))
                return classes2;
        }
        return null;    }
    public static CleanerRepository getRepository(){
        if(repository == null) repository = new CleanerRepositoryImpl();
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
