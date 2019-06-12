package com.dimitri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.dimitri.domain.Classes;
import com.dimitri.service.ClassesService;

import java.util.Set;

@RestController
@RequestMapping("/classes")
public class ClassesController {
    @Autowired
    @Qualifier("ServiceImpl3")

    private ClassesService service;

    @PostMapping("/create")
    @ResponseBody
    public Classes create(Classes classes){
        return service.create(classes);
    }

    @PostMapping("/update")
    @ResponseBody
    public Classes update(Classes classes){
        return service.update(classes);
    }

    @PostMapping("/read/{id}")
    @ResponseBody
    public Classes read(@PathVariable String id){
        return service.read(id);
    }

    @PostMapping("/read/all")
    @ResponseBody
    public Set<Classes> getAll(){
        return service.getAll();
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }

}
