package com.dimitri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.dimitri.domain.Notices;
import com.dimitri.service.NoticesService;

import java.util.Set;

@RestController
@RequestMapping("/notices")
public class NoticesController {
    @Autowired
    @Qualifier("ServiceImpl12")

    private NoticesService service;

    @PostMapping("/create")
    @ResponseBody
    public Notices create(Notices notices){
        return service.create(notices);
    }

    @PostMapping("/update")
    @ResponseBody
    public Notices update(Notices notices){
        return service.update(notices);
    }

    @PostMapping("/read/{id}")
    @ResponseBody
    public Notices read(@PathVariable String id){
        return service.read(id);
    }

    @PostMapping("/read/all")
    @ResponseBody
    public Set<Notices> getAll(){
        return service.getAll();
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
