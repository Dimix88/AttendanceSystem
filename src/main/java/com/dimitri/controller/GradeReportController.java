package com.dimitri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.dimitri.domain.GradeReport;
import com.dimitri.service.GradeReportService;

import java.util.Set;

@RestController
@RequestMapping("/gradeReport")
public class GradeReportController {
    @Autowired
    @Qualifier("GradeReportServiceImpl")
    private GradeReportService service;

    @PostMapping("/create")
    @ResponseBody
    public GradeReport create(@RequestBody GradeReport gradeReport){
        return service.create(gradeReport);
    }

    @PutMapping("/update")
    @ResponseBody
    public GradeReport update(@RequestBody GradeReport gradeReport){
        return service.update(gradeReport);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public GradeReport read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<GradeReport> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
