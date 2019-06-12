package com.dimitri.service.impl;

import com.dimitri.repository.AddressIRepository;
import com.dimitri.repository.impl.AddressIRepositoryImpl;
import com.dimitri.domain.Address;
import com.dimitri.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service("ServiceImpl2")
public class AddressServiceImpl implements AddressService {
    @Autowired
    @Qualifier("AddressRepository")
    private static AddressServiceImpl service = null;
    private AddressIRepository repository = null;

    private AddressServiceImpl(){
        this.repository = AddressIRepositoryImpl.getRepository();
    }
    public static AddressServiceImpl getService(){
        if(service == null) service = new AddressServiceImpl();
        return service;
    }
    @Override
    public Set<Address> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Address create(Address address) {
        return this.repository.create(address);
    }

    @Override
    public Address update(Address address) {
        return this.repository.update(address);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Address read(String s) {
        return this.repository.read(s);
    }
}
