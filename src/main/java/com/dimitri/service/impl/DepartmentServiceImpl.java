package com.dimitri.service.impl;

import com.dimitri.Repository.DepartmentRepository;
import com.dimitri.Repository.impl.DepartmentRepositoryImpl;
import com.dimitri.domain.Department;
import com.dimitri.service.DepartmentService;

import java.util.Set;

public class DepartmentServiceImpl implements DepartmentService {
    private static DepartmentServiceImpl service = null;
    private DepartmentRepository repository = null;

    private DepartmentServiceImpl(){
        this.repository = DepartmentRepositoryImpl.getRepository();
    }
    public static DepartmentServiceImpl getService(){
        if(service == null)service = new DepartmentServiceImpl();
        return service;
    }
    @Override
    public Set<Department> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Department create(Department department) {
        return this.repository.create(department);
    }

    @Override
    public Department update(Department department) {
        return this.repository.update(department);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Department read(String s) {
        return this.repository.read(s);
    }
}
