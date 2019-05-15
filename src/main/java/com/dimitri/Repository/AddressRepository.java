package com.dimitri.Repository;

import com.dimitri.domain.Address;

import java.util.Set;

public interface AddressRepository extends Repository<Address, String> {
    Set<Address>getAll();
}
