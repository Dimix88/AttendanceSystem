package com.dimitri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.dimitri.domain.Semester;
import com.dimitri.service.SemesterService;

import java.util.Set;

@RestController
@RequestMapping("/semester")
public class SemesterController {
    @Autowired
    @Qualifier("ServiceImpl16")

    private SemesterService service;

    @PostMapping("/create")
    @ResponseBody
    public Semester create(Semester semester){
        return service.create(semester);
    }

    @PostMapping("/update")
    @ResponseBody
    public Semester update(Semester semester){
        return service.update(semester);
    }

    @PostMapping("/read/{id}")
    @ResponseBody
    public Semester read(@PathVariable String id){
        return service.read(id);
    }

    @PostMapping("/read/all")
    @ResponseBody
    public Set<Semester> getAll(){
        return service.getAll();
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
