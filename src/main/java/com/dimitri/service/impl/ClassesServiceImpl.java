package com.dimitri.service.impl;

import com.dimitri.repository.ClassesIRepository;
import com.dimitri.repository.impl.ClassesIRepositoryImpl;
import com.dimitri.domain.Classes;
import com.dimitri.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service("ClassesServiceImpl")
public class ClassesServiceImpl implements ClassesService {
    @Autowired
    @Qualifier("ClassesRepository")
    private ClassesIRepository repository = null;

    @Override
    public Set<Classes> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Classes create(Classes classes) {
        return this.repository.create(classes);
    }

    @Override
    public Classes update(Classes classes) {
        return this.repository.update(classes);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Classes read(String s) {
        return this.repository.read(s);
    }
}
