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
    @Qualifier("NameServiceImpl")

    private NameService service;

    @PostMapping("/create")
    @ResponseBody
    public Name create(@RequestBody Name name){
        return service.create(name);
    }

    @PutMapping("/update")
    @ResponseBody
    public Name update(@RequestBody Name name){
        return service.update(name);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Name read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Name> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
