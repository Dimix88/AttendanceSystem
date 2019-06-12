package com.dimitri.repository;

import com.dimitri.domain.Name;
import com.dimitri.repository.IRepository;
import org.springframework.stereotype.Repository;
import java.util.Set;

public interface NameIRepository extends IRepository<Name, String> {
    Set<Name>getAll();
}
