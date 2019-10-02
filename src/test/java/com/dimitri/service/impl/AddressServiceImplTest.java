package com.dimitri.service.impl;

import com.dimitri.repository.AddressIRepository;
//import com.dimitri.repository.impl.AddressIRepositoryImpl;
import com.dimitri.domain.Address;
import com.dimitri.factory.AddressFactory;
import com.dimitri.service.AddressService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressServiceImplTest {
    private AddressService addressService;
    private AddressIRepository repository;
    private Address c1;


    @Before
    public void setUp() throws Exception {
        this.addressService = AddressServiceImpl.getAddressService();
        c1 = AddressFactory.getAddress("22 Park Street","P.O.Box 1","Cape Town","Western Cape");
        this.addressService.create(c1);
    }

    @Test
    public void create() {
        Address address = AddressFactory.getAddress("22 Bank Street","P.O.Box 55","Cape Town","Western Cape");
        this.addressService.create(address);
        String street = "22 Bank Street";
        Assert.assertEquals(address.getStreetAddres(),addressService.read(address.getAddressCode()).getStreetAddres());
        Assert.assertNotNull(address);
        Assert.assertEquals(street, addressService.read(address.getAddressCode()).getStreetAddres());
        Assert.assertSame(address, addressService.read(address.getAddressCode()));
    }

    @Test
    public void update() {
        String newStreet = "Female";
        Address newAddress = new Address.Builder().copy(c1).streetAddress(newStreet).build();
        addressService.update(newAddress);
        Assert.assertEquals(newAddress,addressService.read(c1.getAddressCode()));
    }

    @Test
    public void delete() {
        Address deleteAddress = AddressFactory.getAddress("Pink","","","");
        addressService.create(deleteAddress);
        addressService.delete(deleteAddress.getAddressCode());
        Address result = addressService.read(deleteAddress.getAddressCode());
        Assert.assertFalse(addressService.getAll().iterator().next().getStreetAddres().contains("Pink"));
        Assert.assertNull(result);
    }

    @Test
    public void read() {
        Address read = addressService.read(c1.getAddressCode());
        Assert.assertEquals(read, addressService.read(read.getAddressCode()));
        Assert.assertEquals(read, addressService.read(c1.getAddressCode()));
    }


    @Test
    public void getAll() {
        List<Address> addressesSet= this.addressService.getAll();
        System.out.println("In getAll, all = " + addressesSet);
        Assert.assertSame(addressesSet.size(),addressService.getAll().size());
    }
}