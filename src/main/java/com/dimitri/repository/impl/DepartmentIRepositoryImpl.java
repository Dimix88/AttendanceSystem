/**package com.dimitri.repository.impl;

import com.dimitri.repository.DepartmentIRepository;
import com.dimitri.domain.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Repository("DepartmentRepository")
public class DepartmentIRepositoryImpl implements DepartmentIRepository {
    @Autowired
    private static DepartmentIRepositoryImpl repository = null;
    private Set<Department>departments;

    private DepartmentIRepositoryImpl(){
        this.departments = new HashSet<>();
    }

    private Department findDepartment(String deptCode){
        for (Department department: this.departments){
            if (department.getDeptCode().equals(deptCode))
                return department;
        }
        return null;     }
    public static DepartmentIRepository getRepository(){
        if(repository == null) repository = new DepartmentIRepositoryImpl();
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
        return department;
    }

    @Override
    public void delete(String deptCode) {
        Department department1 = findDepartment(deptCode);
        if(department1 != null){
            this.departments.remove(department1);
        }
    }

    @Override
    public Department read(String deptCode) {
        return findDepartment(deptCode);
    }
    public Set<Department> getAll(){
        return this.departments;
    }
}
**/