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
    @Qualifier("ServiceImpl4")

    private CleanerService service;

    @PostMapping("/create")
    @ResponseBody
    public Cleaner create(Cleaner cleaner){
        return service.create(cleaner);
    }

    @PostMapping("/update")
    @ResponseBody
    public Cleaner update(Cleaner cleaner){
        return service.update(cleaner);
    }

    @PostMapping("/read/{id}")
    @ResponseBody
    public Cleaner read(@PathVariable String id){
        return service.read(id);
    }

    @PostMapping("/read/all")
    @ResponseBody
    public Set<Cleaner> getAll(){
        return service.getAll();
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
