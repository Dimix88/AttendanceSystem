package com.dimitri.controller;

import com.dimitri.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.dimitri.service.StudentService;
import com.dimitri.domain.Student;

import java.util.Set;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    @Qualifier("StudentServiceImpl")
    private StudentService service;

    @PostMapping("/create")
    @ResponseBody
    public Student create(@RequestBody Student student){
        return service.create(student);
    }

    @PutMapping("/update")
    @ResponseBody
    public Student update(@RequestBody Student student){
        return service.update(student);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Student read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public Set<Student> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }

}
