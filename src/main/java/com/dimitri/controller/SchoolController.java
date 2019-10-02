package com.dimitri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.dimitri.domain.School;
import com.dimitri.service.SchoolService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    @Qualifier("SchoolServiceImpl")
    private SchoolService service;

    @PostMapping("/create")
    @ResponseBody
    public School create(@RequestBody School school){
        return service.create(school);
    }

    @PutMapping("/update")
    @ResponseBody
    public School update(@RequestBody School school){
        return service.update(school);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public School read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public List<School> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
