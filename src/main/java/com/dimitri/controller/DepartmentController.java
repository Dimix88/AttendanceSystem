package com.dimitri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.dimitri.domain.Department;
import com.dimitri.service.DepartmentService;

import java.util.Set;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    @Qualifier("ServiceImpl6")

    private DepartmentService service;

    @PostMapping("/create")
    @ResponseBody
    public Department create(Department department){
        return service.create(department);
    }

    @PostMapping("/update")
    @ResponseBody
    public Department update(Department department){
        return service.update(department);
    }

    @PostMapping("/read/{id}")
    @ResponseBody
    public Department read(@PathVariable String id){
        return service.read(id);
    }

    @PostMapping("/read/all")
    @ResponseBody
    public Set<Department> getAll(){
        return service.getAll();
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
