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
    @Qualifier("ServiceImpl18")

    private TimetableService service;

    @PostMapping("/create")
    @ResponseBody
    public Timetable create(Timetable timetable){
        return service.create(timetable);
    }

    @PostMapping("/update")
    @ResponseBody
    public Timetable update(Timetable timetable){
        return service.update(timetable);
    }

    @PostMapping("/read/{id}")
    @ResponseBody
    public Timetable read(@PathVariable String id){
        return service.read(id);
    }

    @PostMapping("/read/all")
    @ResponseBody
    public Set<Timetable> getAll(){
        return service.getAll();
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
