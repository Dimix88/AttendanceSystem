package com.dimitri.service.impl;

import com.dimitri.repository.ImportantdatesIRepository;
//import com.dimitri.repository.impl.ImportantDatesIRepositoryImpl;
import com.dimitri.domain.ImportantDates;
import com.dimitri.service.ImportantdatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("DatesServiceImpl")
public class ImportantDatesServiceImpl implements ImportantdatesService {
    public static ImportantdatesService importantdatesService = null;

    @Autowired
    private ImportantdatesIRepository repository;

    private ImportantDatesServiceImpl(){}

    public static ImportantdatesService getImportantdatesService(){
        if (importantdatesService==null)importantdatesService = new ImportantDatesServiceImpl();
        return importantdatesService;
    }
    @Override
    public List<ImportantDates> getAll() {
        return this.repository.findAll();
    }

    @Override
    public ImportantDates create(ImportantDates importantDates) {
        return this.repository.save(importantDates);
    }

    @Override
    public ImportantDates update(ImportantDates importantDates) {
        return this.repository.save(importantDates);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public ImportantDates read(String s) {
        Optional<ImportantDates>optionalImportantDates = this.repository.findById(s);
        return optionalImportantDates.orElse(null);
    }
}
