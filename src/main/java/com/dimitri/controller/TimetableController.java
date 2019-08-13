package com.dimitri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.dimitri.service.TimetableService;
import com.dimitri.domain.Timetable;

import java.util.Set;

@RestController
@RequestMapping("/timetable")
public class TimetableController {
    @Autowired
    @Qualifier("TimeServiceImpl")

    private TimetableService service;

    @PostMapping("/create")
    @ResponseBody
    public Timetable create(@RequestBody Timetable timetable){
        return service.create(timetable);
    }

    @PutMapping("/update")
    @ResponseBody
    public Timetable update(@RequestBody Timetable timetable){
        return service.update(timetable);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Timetable read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Timetable> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
