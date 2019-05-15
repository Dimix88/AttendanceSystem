package com.dimitri.service.impl;

import com.dimitri.Repository.ImportantdatesRepository;
import com.dimitri.Repository.impl.ImportantDatesRepositoryImpl;
import com.dimitri.domain.ImportantDates;
import com.dimitri.service.ImportantdatesService;

import java.util.Set;

public class ImportantDatesServiceImpl implements ImportantdatesService {
    private static ImportantDatesServiceImpl service = null;
    private ImportantdatesRepository repository = null;

    private ImportantDatesServiceImpl(){
        this.repository = ImportantDatesRepositoryImpl.getRepository();
    }
    public static ImportantDatesServiceImpl getService(){
        if(service == null) service = new ImportantDatesServiceImpl();
        return service;
    }
    @Override
    public Set<ImportantDates> getAll() {
        return this.repository.getAll();
    }

    @Override
    public ImportantDates create(ImportantDates importantDates) {
        return this.repository.create(importantDates);
    }

    @Override
    public ImportantDates update(ImportantDates importantDates) {
        return this.repository.update(importantDates);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public ImportantDates read(String s) {
        return this.repository.read(s);
    }
}
