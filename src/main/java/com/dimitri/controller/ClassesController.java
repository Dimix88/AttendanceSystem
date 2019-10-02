package com.dimitri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.dimitri.domain.Classes;
import com.dimitri.service.ClassesService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/classes")
public class ClassesController {
    @Autowired
    @Qualifier("ClassesServiceImpl")
    private ClassesService service;

    @PostMapping("/create")
    @ResponseBody
    public Classes create(@RequestBody Classes classes){
        return service.create(classes);
    }

    @PutMapping("/update")
    @ResponseBody
    public Classes update(@RequestBody Classes classes){
        return service.update(classes);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Classes read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public List<Classes> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }

}
