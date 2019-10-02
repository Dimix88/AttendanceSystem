package com.dimitri.service;

import com.dimitri.domain.Department;

import java.util.List;

public interface DepartmentService extends IService<Department, String> {
    List<Department> getAll();
}
