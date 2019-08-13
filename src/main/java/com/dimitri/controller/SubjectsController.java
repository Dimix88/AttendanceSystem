package com.dimitri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.dimitri.service.SubjectsService;
import com.dimitri.domain.Subjects;

import java.util.Set;

@RestController
@RequestMapping("/subjects")
public class SubjectsController {
    @Autowired
    @Qualifier("SubjectsServiceImpl")

    private SubjectsService service;

    @PostMapping("/create")
    @ResponseBody
    public Subjects create(@RequestBody Subjects subjects){
        return service.create(subjects);
    }

    @PutMapping("/update")
    @ResponseBody
    public Subjects update(@RequestBody Subjects subjects){
        return service.update(subjects);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Subjects read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Subjects> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
