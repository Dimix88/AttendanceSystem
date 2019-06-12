package com.dimitri.service.impl;

import com.dimitri.repository.SubjectsIRepository;
import com.dimitri.repository.impl.SubjectsIRepositoryImpl;
import com.dimitri.domain.Subjects;
import com.dimitri.service.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service("ServiceImpl17")
public class SubjectsServiceImpl implements SubjectsService {
    @Autowired
    @Qualifier("SubjectsRepository")
    private static SubjectsServiceImpl service = null;
    private SubjectsIRepository repository = null;

    private SubjectsServiceImpl(){
        this.repository = SubjectsIRepositoryImpl.getRepository();
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
