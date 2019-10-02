package com.dimitri.service.impl;

import com.dimitri.repository.NameIRepository;
//import com.dimitri.repository.impl.NameIRepositoryImpl;
import com.dimitri.domain.Name;
import com.dimitri.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("NameServiceImpl")
public class NameServiceImpl implements NameService {
    public static NameService nameService = null;

    @Autowired
    private NameIRepository repository;

    private NameServiceImpl(){}

    public static NameService getNameService(){
        if (nameService==null)nameService = new NameServiceImpl();
        return nameService;
    }
    @Override
    public List<Name> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Name create(Name name) {
        return this.repository.save(name);
    }

    @Override
    public Name update(Name name) {
        return this.repository.save(name);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Name read(String s) {
        Optional<Name>optionalName = this.repository.findById(s);
        return optionalName.orElse(null);
    }
}
