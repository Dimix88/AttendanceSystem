package com.dimitri.controller;

import com.dimitri.domain.Cleaner;
import com.dimitri.service.CleanerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/cleaner")
public class CleanerController {
    @Autowired
    @Qualifier("CleanerServiceImpl")
    private CleanerService service;

    @PostMapping("/create")
    @ResponseBody
    public Cleaner create(@RequestBody Cleaner cleaner){
        return service.create(cleaner);
    }

    @PutMapping("/update")
    @ResponseBody
    public Cleaner update(@RequestBody Cleaner cleaner){
        return service.update(cleaner);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Cleaner read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Cleaner> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
