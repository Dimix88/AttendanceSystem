package com.dimitri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.dimitri.service.AdminService;
import com.dimitri.domain.Admin;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    @Qualifier("AdminServiceImpl")
    private AdminService service;

    @PostMapping("/create")
    @ResponseBody
    public Admin create(@RequestBody Admin admin){
        return service.create(admin);
    }

    @PutMapping("/update")
    @ResponseBody
    public Admin update(@RequestBody Admin admin){
        return service.update(admin);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Admin read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public List<Admin> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }

}
