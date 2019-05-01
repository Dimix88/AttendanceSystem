package com.dimitri.Repository;

import com.dimitri.domain.Department;

import java.util.Set;

public interface DepartmentRepository extends Repository<Department, String> {
    Set<Department>getAll();
}

