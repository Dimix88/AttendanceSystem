package com.dimitri.repository;

import com.dimitri.domain.Admin;
import com.dimitri.repository.IRepository;
import org.springframework.stereotype.Repository;
import java.util.Set;

public interface AdminIRepository extends IRepository<Admin, String> {
    Set<Admin>getAll();
}
