package com.dimitri.service;

import com.dimitri.domain.Address;

import java.util.Set;

public interface AddressService extends IService<Address, String> {
    Set<Address>getAll();
}
