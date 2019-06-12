package com.dimitri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.dimitri.service.AdminService;
import com.dimitri.domain.Admin;

import java.util.Set;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    @Qualifier("ServiceImpl1")

    private AdminService service;

    @PostMapping("/create")
    @ResponseBody
    public Admin create(Admin admin){
        return service.create(admin);
    }

    @PostMapping("/update")
    @ResponseBody
    public Admin update(Admin admin){
        return service.update(admin);
    }

    @PostMapping("/read/{id}")
    @ResponseBody
    public Admin read(@PathVariable String id){
        return service.read(id);
    }

    @PostMapping("/read/all")
    @ResponseBody
    public Set<Admin> getAll(){
        return service.getAll();
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }

}
