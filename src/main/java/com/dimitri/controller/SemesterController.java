package com.dimitri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.dimitri.domain.Semester;
import com.dimitri.service.SemesterService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/semester")
public class SemesterController {
    @Autowired
    @Qualifier("SemesterServiceImpl")
    private SemesterService service;

    @PostMapping("/create")
    @ResponseBody
    public Semester create(@RequestBody Semester semester){
        return service.create(semester);
    }

    @PutMapping("/update")
    @ResponseBody
    public Semester update(@RequestBody Semester semester){
        return service.update(semester);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Semester read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public List<Semester> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
