package com.dimitri.repository;

import com.dimitri.domain.Security;
import com.dimitri.repository.IRepository;
import org.springframework.stereotype.Repository;
import java.util.Set;

public interface SecurityIRepository extends IRepository<Security, String> {
    Set<Security>getAll();
}
