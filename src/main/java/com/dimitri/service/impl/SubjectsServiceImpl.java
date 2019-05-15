package com.dimitri.service.impl;

import com.dimitri.Repository.SubjectsRepository;
import com.dimitri.Repository.impl.SubjectsRepositoryImpl;
import com.dimitri.domain.Subjects;
import com.dimitri.service.SubjectsService;

import java.util.Set;

public class SubjectsServiceImpl implements SubjectsService {
    private static SubjectsServiceImpl service = null;
    private SubjectsRepository repository = null;

    private SubjectsServiceImpl(){
        this.repository = SubjectsRepositoryImpl.getRepository();
    }
    public static SubjectsServiceImpl getService(){
        if(service == null) service = new SubjectsServiceImpl();
        return service;
    }
    @Override
    public Set<Subjects> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Subjects create(Subjects subjects) {
        return this.repository.create(subjects);
    }

    @Override
    public Subjects update(Subjects subjects) {
        return this.repository.update(subjects);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Subjects read(String s) {
        return this.repository.read(s);
    }
}
