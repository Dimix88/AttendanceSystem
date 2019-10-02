package com.dimitri.controller;

import com.dimitri.domain.CollegeSubjects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.dimitri.service.SubjectsService;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectsController {
    @Autowired
    @Qualifier("SubjectsServiceImpl")
    private SubjectsService service;

    @PostMapping("/create")
    @ResponseBody
    public CollegeSubjects create(@RequestBody CollegeSubjects collegeSubjects){
        return service.create(collegeSubjects);
    }

    @PutMapping("/update")
    @ResponseBody
    public CollegeSubjects update(@RequestBody CollegeSubjects collegeSubjects){
        return service.update(collegeSubjects);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public CollegeSubjects read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public List<CollegeSubjects> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
