package com.dimitri.service.impl;

import com.dimitri.repository.DepartmentIRepository;
import com.dimitri.repository.impl.DepartmentIRepositoryImpl;
import com.dimitri.domain.Department;
import com.dimitri.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service("ServiceImpl6")
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    @Qualifier("DepartmentRepository")
    private static DepartmentServiceImpl service = null;
    private DepartmentIRepository repository = null;

    private DepartmentServiceImpl(){
        this.repository = DepartmentIRepositoryImpl.getRepository();
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
