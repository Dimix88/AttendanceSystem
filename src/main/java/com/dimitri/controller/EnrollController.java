package com.dimitri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.dimitri.service.EnrollService;
import com.dimitri.domain.Enroll;

import java.util.Set;

@RestController
@RequestMapping("/enroll")
public class EnrollController {
    @Autowired
    @Qualifier("ServiceImpl7")

    private EnrollService service;

    @PostMapping("/create")
    @ResponseBody
    public Enroll create(Enroll enroll){
        return service.create(enroll);
    }

    @PostMapping("/update")
    @ResponseBody
    public Enroll update(Enroll enroll){
        return service.update(enroll);
    }

    @PostMapping("/read/{id}")
    @ResponseBody
    public Enroll read(@PathVariable String id){
        return service.read(id);
    }

    @PostMapping("/read/all")
    @ResponseBody
    public Set<Enroll> getAll(){
        return service.getAll();
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }

}
