package com.dimitri.service.impl;

import com.dimitri.domain.CollegeSubjects;
import com.dimitri.repository.SubjectsIRepository;
//import com.dimitri.repository.impl.SubjectsIRepositoryImpl;
import com.dimitri.service.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("SubjectsServiceImpl")
public class SubjectsServiceImpl implements SubjectsService {
    public static SubjectsService subjectsService = null;

    @Autowired
    private SubjectsIRepository repository;

    private SubjectsServiceImpl(){}

    public static SubjectsService getSubjectsService(){
        if (subjectsService==null)subjectsService = new SubjectsServiceImpl();
        return subjectsService;
    }
    @Override
    public List<CollegeSubjects> getAll() {
        return this.repository.findAll();
    }

    @Override
    public CollegeSubjects create(CollegeSubjects collegeSubjects) {
        return this.repository.save(collegeSubjects);
    }

    @Override
    public CollegeSubjects update(CollegeSubjects collegeSubjects) {
        return this.repository.save(collegeSubjects);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public CollegeSubjects read(String s) {
        Optional<CollegeSubjects>optionalSubjects = this.repository.findById(s);
        return optionalSubjects.orElse(null);
    }
}
