package com.dimitri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.dimitri.domain.Lecturer;
import com.dimitri.service.LecturerService;
import java.util.Set;

@RestController
@RequestMapping("/lecturer")
public class LecturerController {
    @Autowired
    @Qualifier("ServiceImpl10")

    private LecturerService service;

    @PostMapping("/create")
    @ResponseBody
    public Lecturer create(Lecturer lecturer){
        return service.create(lecturer);
    }

    @PostMapping("/update")
    @ResponseBody
    public Lecturer update(Lecturer lecturer){
        return service.update(lecturer);
    }

    @PostMapping("/read/{id}")
    @ResponseBody
    public Lecturer read(@PathVariable String id){
        return service.read(id);
    }

    @PostMapping("/read/all")
    @ResponseBody
    public Set<Lecturer> getAll(){
        return service.getAll();
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
