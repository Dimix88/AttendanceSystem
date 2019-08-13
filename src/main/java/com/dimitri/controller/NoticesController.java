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
    @Qualifier("NoticeServiceImpl")
    private NoticesService service;

    @PostMapping("/create")
    @ResponseBody
    public Notices create(@RequestBody Notices notices){
        return service.create(notices);
    }

    @PutMapping("/update")
    @ResponseBody
    public Notices update(@RequestBody Notices notices){
        return service.update(notices);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Notices read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Notices> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
