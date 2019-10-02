package com.dimitri.service;

import com.dimitri.domain.Address;

import java.util.List;

public interface AddressService extends IService<Address, String> {

    List<Address> getAll();
}
