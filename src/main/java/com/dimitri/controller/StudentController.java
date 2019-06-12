package com.dimitri.controller;

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
    @Qualifier("ServiceImpl")

    private StudentService service;

    @PostMapping("/create")
    @ResponseBody
    public Student create(Student student){
        return service.create(student);
    }

    @PostMapping("/update")
    @ResponseBody
    public Student update(Student student){
        return service.update(student);
    }

    @PostMapping("/read/{id}")
    @ResponseBody
    public Student read(@PathVariable String id){
        return service.read(id);
    }

    @PostMapping("/read/all")
    @ResponseBody
    public Set<Student> getAll(){
        return service.getAll();
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }

}
