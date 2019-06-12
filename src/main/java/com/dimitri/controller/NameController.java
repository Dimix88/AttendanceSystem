package com.dimitri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.dimitri.service.NameService;
import com.dimitri.domain.Name;

import java.util.Set;

@RestController
@RequestMapping("/name")
public class NameController {
    @Autowired
    @Qualifier("ServiceImpl11")

    private NameService service;

    @PostMapping("/create")
    @ResponseBody
    public Name create(Name name){
        return service.create(name);
    }

    @PostMapping("/update")
    @ResponseBody
    public Name update(Name name){
        return service.update(name);
    }

    @PostMapping("/read/{id}")
    @ResponseBody
    public Name read(@PathVariable String id){
        return service.read(id);
    }

    @PostMapping("/read/all")
    @ResponseBody
    public Set<Name> getAll(){
        return service.getAll();
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
