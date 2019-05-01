package com.dimitri.Repository.impl;

import com.dimitri.Repository.DepartmentRepository;
import com.dimitri.Repository.Repository;
import com.dimitri.domain.Department;

import java.util.HashSet;
import java.util.Set;

public class DepartmentRepositoryImpl implements DepartmentRepository {
    private static DepartmentRepositoryImpl repository = null;
    private Set<Department>departments;

    private DepartmentRepositoryImpl(){
        this.departments = new HashSet<>();
    }

    private Department findDepartment(String deptCode){
        for (Department department: this.departments){
            if (department.getDeptCode().equals(deptCode))
                return department;
        }
        return null;     }
    public static DepartmentRepository getRepository(){
        if(repository == null) repository = new DepartmentRepositoryImpl();
        return repository;
    }
    @Override
    public Department create(Department department) {
        this.departments.add(department);
        return department;
    }

    @Override
    public Department update(Department department) {
        Department toDelete = findDepartment(department.getDeptCode());
        if(toDelete != null) {
            this.departments.remove(toDelete);
            return create(department);
        }
        return null;
    }

    @Override
    public void delete(String deptCode) {
        this.departments.removeIf(department -> department.getDeptCode()==deptCode);
    }

    @Override
    public Department read(String deptCode) {
        return findDepartment(deptCode);
    }
    public Set<Department> getAll(){
        return this.departments;
    }
}
