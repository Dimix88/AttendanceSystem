package com.dimitri.Repository.impl;

import com.dimitri.Repository.AddressRepository;
import com.dimitri.domain.Address;

import java.util.HashSet;
import java.util.Set;

public class AddressRepositoryImpl implements AddressRepository{
    private static AddressRepositoryImpl repository = null;
    private Set<Address> addresses;

    private AddressRepositoryImpl(){
        this.addresses = new HashSet<>();
    }

    private Address findAddress(String street){
        for (Address classes2: this.addresses){
            if (classes2.getStreetAddres().equals(street))
                return classes2;
        }
        return null;    }
    public static AddressRepositoryImpl getRepository(){
        if(repository == null) repository = new AddressRepositoryImpl();
        return repository;
    }
    @Override
    public Address create(Address address) {
        this.addresses.add(address);
        return address;
    }

    @Override
    public Address update(Address address) {
        Address toDelete = findAddress(address.getStreetAddres());
        if(toDelete != null) {
            this.addresses.remove(toDelete);
            return create(address);
        }
        return null;
    }

    @Override
    public void delete(String street) {
        Address class1 = findAddress(street);
        if(class1 != null){
            this.addresses.remove(class1);
        }    }

    @Override
    public Address read(String street) {
        return findAddress(street);
    }
    public Set<Address> getAll(){
        return this.addresses;
    }
}
