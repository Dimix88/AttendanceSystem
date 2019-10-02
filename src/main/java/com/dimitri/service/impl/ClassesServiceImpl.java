package com.dimitri.service.impl;

import com.dimitri.repository.ClassesIRepository;
//import com.dimitri.repository.impl.ClassesIRepositoryImpl;
import com.dimitri.domain.Classes;
import com.dimitri.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("ClassesServiceImpl")
public class ClassesServiceImpl implements ClassesService {
    public static ClassesService classesService = null;

    @Autowired
    private ClassesIRepository repository;

    private ClassesServiceImpl(){}

    public static ClassesService getClassesService(){
        if(classesService==null)classesService = new ClassesServiceImpl();
        return classesService;
    }
    @Override
    public List<Classes> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Classes create(Classes classes) {
        return this.repository.save(classes);
    }

    @Override
    public Classes update(Classes classes) {
        return this.repository.save(classes);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Classes read(String s) {
        Optional<Classes>optionalClasses = this.repository.findById(s);
        return optionalClasses.orElse(null);
    }
}
