package com.dimitri.service.impl;

import com.dimitri.repository.AddressIRepository;
import com.dimitri.repository.impl.AddressIRepositoryImpl;
import com.dimitri.domain.Address;
import com.dimitri.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service("AddressServiceImpl")
public class AddressServiceImpl implements AddressService {
    @Autowired
    @Qualifier("AddressRepository")
    private AddressIRepository repository = null;

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
