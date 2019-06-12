package com.dimitri.repository.impl;

import com.dimitri.repository.ImportantdatesIRepository;
import com.dimitri.domain.ImportantDates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Repository("ImportantDatesRepository")
public class ImportantDatesIRepositoryImpl implements ImportantdatesIRepository {
    @Autowired
    private static ImportantDatesIRepositoryImpl repository = null;
    private Set<ImportantDates> importantDates;

    private ImportantDatesIRepositoryImpl(){
        this.importantDates = new HashSet<>();
    }

    private ImportantDates findImportantDates(String sDate){
        for (ImportantDates classes2: this.importantDates){
            if (classes2.getsDate().equals(sDate))
                return classes2;
        }
        return null;    }
    public static ImportantdatesIRepository getRepository(){
        if(repository == null) repository = new ImportantDatesIRepositoryImpl();
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
