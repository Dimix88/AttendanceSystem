package com.dimitri.controller;

import com.dimitri.domain.CollegeTimetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.dimitri.service.TimetableService;

import java.util.List;

@RestController
@RequestMapping("/timetable")
public class TimetableController {
    @Autowired
    @Qualifier("TimeServiceImpl")
    private TimetableService service;

    @PostMapping("/create")
    @ResponseBody
    public CollegeTimetable create(@RequestBody CollegeTimetable collegeTimetable){
        return service.create(collegeTimetable);
    }

    @PutMapping("/update")
    @ResponseBody
    public CollegeTimetable update(@RequestBody CollegeTimetable collegeTimetable){
        return service.update(collegeTimetable);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public CollegeTimetable read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public List<CollegeTimetable> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
