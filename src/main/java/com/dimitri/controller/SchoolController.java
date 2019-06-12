package com.dimitri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.dimitri.domain.School;
import com.dimitri.service.SchoolService;

import java.util.Set;

@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    @Qualifier("ServiceImpl14")

    private SchoolService service;

    @PostMapping("/create")
    @ResponseBody
    public School create(School school){
        return service.create(school);
    }

    @PostMapping("/update")
    @ResponseBody
    public School update(School school){
        return service.update(school);
    }

    @PostMapping("/read/{id}")
    @ResponseBody
    public School read(@PathVariable String id){
        return service.read(id);
    }

    @PostMapping("/read/all")
    @ResponseBody
    public Set<School> getAll(){
        return service.getAll();
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
