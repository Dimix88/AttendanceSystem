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
    @Qualifier("ServiceImpl17")

    private SubjectsService service;

    @PostMapping("/create")
    @ResponseBody
    public Subjects create(Subjects subjects){
        return service.create(subjects);
    }

    @PostMapping("/update")
    @ResponseBody
    public Subjects update(Subjects subjects){
        return service.update(subjects);
    }

    @PostMapping("/read/{id}")
    @ResponseBody
    public Subjects read(@PathVariable String id){
        return service.read(id);
    }

    @PostMapping("/read/all")
    @ResponseBody
    public Set<Subjects> getAll(){
        return service.getAll();
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
