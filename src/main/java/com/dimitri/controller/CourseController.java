package com.dimitri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.dimitri.service.CourseService;
import com.dimitri.domain.Course;

import java.util.Set;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    @Qualifier("ServiceImpl5")

    private CourseService service;

    @PostMapping("/create")
    @ResponseBody
    public Course create(Course course){
        return service.create(course);
    }

    @PostMapping("/update")
    @ResponseBody
    public Course update(Course course){
        return service.update(course);
    }

    @PostMapping("/read/{id}")
    @ResponseBody
    public Course read(@PathVariable String id){
        return service.read(id);
    }

    @PostMapping("/read/all")
    @ResponseBody
    public Set<Course> getAll(){
        return service.getAll();
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
