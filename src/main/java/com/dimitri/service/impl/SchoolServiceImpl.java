package com.dimitri.service.impl;

import com.dimitri.repository.SchoolIRepository;
import com.dimitri.repository.impl.SchoolIRepositoryImpl;
import com.dimitri.domain.School;
import com.dimitri.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service("SchoolServiceImpl")
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    @Qualifier("SchoolRepository")
    private SchoolIRepository repository = null;

    @Override
    public School create(School school) {
        return this.repository.create(school);
    }

    @Override
    public School update(School school) {
        return this.repository.update(school);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public School read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<School> getAll() {
        return this.repository.getAll();
    }
}
