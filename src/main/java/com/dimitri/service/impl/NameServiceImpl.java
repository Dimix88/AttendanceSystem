package com.dimitri.service.impl;

import com.dimitri.repository.NameIRepository;
import com.dimitri.repository.impl.NameIRepositoryImpl;
import com.dimitri.domain.Name;
import com.dimitri.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service("ServiceImpl11")
public class NameServiceImpl implements NameService {
    @Autowired
    @Qualifier("NameRepository")
    private static NameServiceImpl service = null;
    private NameIRepository repository = null;

    private NameServiceImpl(){
        this.repository = NameIRepositoryImpl.getRepository();
    }
    public static NameServiceImpl getService(){
        if(service == null) service = new NameServiceImpl();
        return service;
    }
    @Override
    public Set<Name> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Name create(Name name) {
        return this.repository.create(name);
    }

    @Override
    public Name update(Name name) {
        return this.repository.update(name);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Name read(String s) {
        return this.repository.read(s);
    }
}
