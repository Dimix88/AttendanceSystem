package com.dimitri.service.impl;

import com.dimitri.repository.AddressIRepository;
//import com.dimitri.repository.impl.AddressIRepositoryImpl;
import com.dimitri.domain.Address;
import com.dimitri.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("AddressServiceImpl")
public class AddressServiceImpl implements AddressService {
    private static AddressService addressService=null;

    @Autowired
    private AddressIRepository repository;

    private AddressServiceImpl(){}

    public static AddressService getAddressService(){
        if(addressService==null) addressService = new AddressServiceImpl();
        return addressService;
    }


    @Override
    public List<Address> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Address create(Address address) {
        return this.repository.save(address);
    }

    @Override
    public Address update(Address address) {
        return this.repository.save(address);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Address read(String s) {
        Optional<Address>optionalAddress = this.repository.findById(s);
        return optionalAddress.orElse(null);
    }

}
