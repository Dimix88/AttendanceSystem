package com.dimitri.Repository.impl;

import com.dimitri.Repository.ImportantdatesRepository;
import com.dimitri.domain.ImportantDates;

import java.util.HashSet;
import java.util.Set;

public class ImportantDatesRepositoryImpl implements ImportantdatesRepository {
    private static ImportantDatesRepositoryImpl repository = null;
    private Set<ImportantDates> importantDates;

    private ImportantDatesRepositoryImpl(){
        this.importantDates = new HashSet<>();
    }

    private ImportantDates findImportantDates(String sDate){
        for (ImportantDates classes2: this.importantDates){
            if (classes2.getsDate().equals(sDate))
                return classes2;
        }
        return null;    }
    public static ImportantdatesRepository getRepository(){
        if(repository == null) repository = new ImportantDatesRepositoryImpl();
        return repository;
    }
    @Override
    public ImportantDates create(ImportantDates importantDates) {
        this.importantDates.add(importantDates);
        return importantDates;
    }

    @Override
    public ImportantDates update(ImportantDates importantDates) {
        ImportantDates toDelete = findImportantDates(importantDates.getsDate());
        if(toDelete != null) {
            this.importantDates.remove(toDelete);
            return create(importantDates);
        }
        return null;
    }

    @Override
    public void delete(String importantDates) {
        ImportantDates class1 = findImportantDates(importantDates);
        if(class1 != null){
            this.importantDates.remove(class1);
        }    }

    @Override
    public ImportantDates read(String importantDates) {
        return findImportantDates(importantDates);
    }
    public Set<ImportantDates> getAll(){
        return this.importantDates;
    }
}
