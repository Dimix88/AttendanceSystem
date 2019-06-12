package com.dimitri.repository;

import com.dimitri.domain.Department;
import com.dimitri.repository.IRepository;
import org.springframework.stereotype.Repository;
import java.util.Set;

public interface DepartmentIRepository extends IRepository<Department, String> {
    Set<Department>getAll();
}

