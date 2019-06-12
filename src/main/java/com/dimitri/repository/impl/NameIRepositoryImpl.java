package com.dimitri.repository.impl;

import com.dimitri.repository.NameIRepository;
import com.dimitri.domain.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Repository("NameRepository")
public class NameIRepositoryImpl implements NameIRepository {
    @Autowired
    private static NameIRepositoryImpl repository = null;
    private Set<Name>names;

    private NameIRepositoryImpl(){
        this.names = new HashSet<>();
    }

    private Name findName(String firtName){
        for (Name classes2: this.names){
            if (classes2.getFirstname().equals(firtName))
                return classes2;
        }
        return null;    }
    public static NameIRepository getRepository(){
        if(repository == null) repository = new NameIRepositoryImpl();
        return repository;
    }
    @Override
    public Name create(Name name) {
        this.names.add(name);
        return name;
    }

    @Override
    public Name update(Name name) {
        Name toDelete = findName(name.getFirstname());
        if(toDelete != null) {
            this.names.remove(toDelete);
            return create(name);
        }
        return null;
    }

    @Override
    public void delete(String firstName) {
        Name class1 = findName(firstName);
        if(class1 != null){
            this.names.remove(class1);
        }    }

    @Override
    public Name read(String firstName) {
        return findName(firstName);
    }
    public Set<Name> getAll(){
        return this.names;
    }
}
