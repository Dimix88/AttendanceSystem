package com.dimitri.service.impl;

import com.dimitri.repository.DepartmentIRepository;
//import com.dimitri.repository.impl.DepartmentIRepositoryImpl;
import com.dimitri.domain.Department;
import com.dimitri.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("DepartmentServiceImpl")
public class DepartmentServiceImpl implements DepartmentService {
    public static DepartmentService departmentService = null;
    @Autowired
    private DepartmentIRepository repository;

    private DepartmentServiceImpl(){}

    public static DepartmentService getDepartmentService(){
        if (departmentService==null)departmentService= new DepartmentServiceImpl();
        return departmentService;
    }
    @Override
    public List<Department> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Department create(Department department) {
        return this.repository.save(department);
    }

    @Override
    public Department update(Department department) {
        return this.repository.save(department);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Department read(String s) {
        Optional<Department>optionalDepartment = this.repository.findById(s);
        return optionalDepartment.orElse(null);
    }
}
