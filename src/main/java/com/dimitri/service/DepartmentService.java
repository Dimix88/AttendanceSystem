package com.dimitri.service;

import com.dimitri.domain.Department;

import java.util.Set;

public interface DepartmentService extends IService<Department, String> {
    Set<Department>getAll();
}
