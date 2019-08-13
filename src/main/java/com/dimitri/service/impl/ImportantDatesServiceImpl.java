package com.dimitri.service.impl;

import com.dimitri.repository.ImportantdatesIRepository;
import com.dimitri.repository.impl.ImportantDatesIRepositoryImpl;
import com.dimitri.domain.ImportantDates;
import com.dimitri.service.ImportantdatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service("DatesServiceImpl")
public class ImportantDatesServiceImpl implements ImportantdatesService {
    @Autowired
    @Qualifier("ImportantDatesRepository")
    private ImportantdatesIRepository repository = null;

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
