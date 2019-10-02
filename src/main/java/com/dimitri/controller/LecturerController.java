package com.dimitri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.dimitri.domain.Lecturer;
import com.dimitri.service.LecturerService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/lecturer")
public class LecturerController {
    @Autowired
    @Qualifier("LecturerServiceImpl")
    private LecturerService service;

    @PostMapping("/create")
    @ResponseBody
    public Lecturer create(@RequestBody Lecturer lecturer){
        return service.create(lecturer);
    }

    @PutMapping("/update")
    @ResponseBody
    public Lecturer update(@RequestBody Lecturer lecturer){
        return service.update(lecturer);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Lecturer read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public List<Lecturer> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
