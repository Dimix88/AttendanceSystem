package com.dimitri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.dimitri.service.SecurityService;
import com.dimitri.domain.Security;

import java.util.Set;

@RestController
@RequestMapping("/security")
public class SecurityController {
    @Autowired
    @Qualifier("SecurityServiceImpl")

    private SecurityService service;

    @PostMapping("/create")
    @ResponseBody
    public Security create(@RequestBody Security security){
        return service.create(security);
    }

    @PutMapping("/update")
    @ResponseBody
    public Security update(@RequestBody Security security){
        return service.update(security);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Security read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Security> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
