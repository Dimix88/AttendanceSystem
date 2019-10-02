package com.dimitri.service.impl;

import com.dimitri.repository.SchoolIRepository;
//import com.dimitri.repository.impl.SchoolIRepositoryImpl;
import com.dimitri.domain.School;
import com.dimitri.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("SchoolServiceImpl")
public class SchoolServiceImpl implements SchoolService {
    public static SchoolService schoolService = null;

    @Autowired
    private SchoolIRepository repository;

    private SchoolServiceImpl(){}

    public static SchoolService getSchoolService(){
        if (schoolService==null)schoolService = new SchoolServiceImpl();
        return schoolService;
    }

    @Override
    public School create(School school) {
        return this.repository.save(school);
    }

    @Override
    public School update(School school) {
        return this.repository.save(school);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public School read(String s) {
        Optional<School>optionalSchool = this.repository.findById(s);
        return optionalSchool.orElse(null);
    }

    @Override
    public List<School> getAll() {
        return this.repository.findAll();
    }
}
