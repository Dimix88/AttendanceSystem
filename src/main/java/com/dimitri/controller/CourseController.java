package com.dimitri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.dimitri.service.CourseService;
import com.dimitri.domain.Course;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    @Qualifier("CourseServiceImpl")
    private CourseService service;

    @PostMapping("/create")
    @ResponseBody
    public Course create(@RequestBody Course course){
        return service.create(course);
    }

    @PutMapping("/update")
    @ResponseBody
    public Course update(@RequestBody Course course){
        return service.update(course);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Course read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public List<Course> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
