package com.dimitri.service.impl;

import com.dimitri.Repository.AddressRepository;
import com.dimitri.Repository.impl.AddressRepositoryImpl;
import com.dimitri.domain.Address;
import com.dimitri.service.AddressService;

import java.util.Set;

public class AddressServiceImpl implements AddressService {
    private static AddressServiceImpl service = null;
    private AddressRepository repository = null;

    private AddressServiceImpl(){
        this.repository = AddressRepositoryImpl.getRepository();
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
