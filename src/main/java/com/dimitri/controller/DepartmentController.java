package com.dimitri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.dimitri.domain.Department;
import com.dimitri.service.DepartmentService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    @Qualifier("DepartmentServiceImpl")
    private DepartmentService service;

    @PostMapping("/create")
    @ResponseBody
    public Department create(@RequestBody Department department){
        return service.create(department);
    }

    @PutMapping("/update")
    @ResponseBody
    public Department update(@RequestBody Department department){
        return service.update(department);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Department read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public List<Department> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
