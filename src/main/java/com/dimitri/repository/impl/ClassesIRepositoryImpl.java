/**package com.dimitri.repository.impl;

import com.dimitri.repository.ClassesIRepository;
import com.dimitri.domain.Classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Repository("ClassesRepository")
public class ClassesIRepositoryImpl implements ClassesIRepository {
    @Autowired
    private static ClassesIRepositoryImpl repository = null;
    private Set<Classes> classes;

    private ClassesIRepositoryImpl(){
        this.classes = new HashSet<>();
    }

    private Classes findClass(String classCode){
        for (Classes classes2: this.classes){
            if (classes2.getClassCode().equals(classCode))
                return classes2;
        }
            return null;
    }
    public static ClassesIRepository getRepository(){
        if(repository == null) repository = new ClassesIRepositoryImpl();
        return repository;
    }
    @Override
    public Classes create(Classes classes1) {
        this.classes.add(classes1);
        return classes1;
    }

    @Override
    public Classes update(Classes classes1) {
        Classes toDelete = findClass(classes1.getClassCode());
        if(toDelete != null) {
            this.classes.remove(toDelete);
            return create(classes1);
        }
        return classes1;
    }

    @Override
    public void delete(String classCode) {
        Classes class1 = findClass(classCode);
        if(class1 != null){
            this.classes.remove(class1);
        }

    }

    @Override
    public Classes read(final String classcode) {
        return findClass(classcode);
    }
    public Set<Classes>getAll(){
        return this.classes;
    }
}
**/