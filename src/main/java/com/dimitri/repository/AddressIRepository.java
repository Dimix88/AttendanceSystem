package com.dimitri.repository;

import com.dimitri.domain.Address;
import com.dimitri.repository.IRepository;
import org.springframework.stereotype.Repository;
import java.util.Set;

public interface AddressIRepository extends IRepository<Address, String> {
    Set<Address>getAll();
}
