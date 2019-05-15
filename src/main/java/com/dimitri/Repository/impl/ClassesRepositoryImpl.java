package com.dimitri.Repository.impl;

import com.dimitri.Repository.ClassesRepository;
import com.dimitri.Repository.Repository;
import com.dimitri.domain.Classes;
import java.util.function.Predicate;
import java.util.HashSet;
import java.util.Set;

public class ClassesRepositoryImpl implements ClassesRepository {
    private static ClassesRepositoryImpl repository = null;
    private Set<Classes> classes;

    private ClassesRepositoryImpl(){
        this.classes = new HashSet<>();
    }

    private Classes findClass(String classCode){
        for (Classes classes2: this.classes){
            if (classes2.getClassCode().equals(classCode))
                return classes2;
        }
            return null;
    }
    public static ClassesRepository getRepository(){
        if(repository == null) repository = new ClassesRepositoryImpl();
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
