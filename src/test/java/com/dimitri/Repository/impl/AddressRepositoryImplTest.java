package com.dimitri.Repository.impl;

import com.dimitri.Repository.AddressRepository;
import com.dimitri.domain.Address;
import com.dimitri.factory.AddressFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class AddressRepositoryImplTest {

    private AddressRepository repository;
    private Address c1;
    Set<Address> addresses = new HashSet<>();

    @Before
    public void setUp() throws Exception {
        this.repository = AddressRepositoryImpl.getRepository();
        c1 = AddressFactory.getAddress("22 Park Street","P.O.Box 1","Cape Town","Western Cape");

    }

    @Test
    public void create() {
        Address address= this.repository.create(this.c1);
        String street = "22 Park Street";
        System.out.println("In create, created = " + address);
        Assert.assertEquals(street,address.getStreetAddres());
        Assert.assertNotNull(address);
        Assert.assertSame(address, this.c1);
    }

    @Test
    public void update() {
        Address address= this.repository.create(this.c1);
        String newStreet = "133 Pink Street";
        Address newAddress = new Address.Builder().copy(address).streetAddress(newStreet).build();
        this.repository.create(newAddress);
        System.out.println("In update, Will update = " + newAddress);
        Address updated = this.repository.update(newAddress);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newAddress.getStreetAddres(), updated.getStreetAddres());
    }

    @Test
    public void delete() {
        Address address= this.repository.create(this.c1);
        this.repository.delete(address.getStreetAddres());
        System.out.println(this.addresses);
    }

    @Test
    public void read() {
        Address address= this.repository.create(this.c1);
        System.out.println("In read, courseId = "+ address.getStreetAddres());
        Address read = this.repository.read(address.getStreetAddres());
        System.out.println("In read, read = "+ read);
        Assert.assertEquals(c1.getStreetAddres(), this.repository.read(c1.getStreetAddres()).getStreetAddres());

    }


    @Test
    public void getAll() {
        Set<Address> addressesSet= this.repository.getAll();
        System.out.println("In getAll, all = " + addressesSet);
        Assert.assertSame(1, addressesSet.size());
    }
}