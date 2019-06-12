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
    @Qualifier("ServiceImpl8")

    private GradeReportService service;

    @PostMapping("/create")
    @ResponseBody
    public GradeReport create(GradeReport gradeReport){
        return service.create(gradeReport);
    }

    @PostMapping("/update")
    @ResponseBody
    public GradeReport update(GradeReport gradeReport){
        return service.update(gradeReport);
    }

    @PostMapping("/read/{id}")
    @ResponseBody
    public GradeReport read(@PathVariable String id){
        return service.read(id);
    }

    @PostMapping("/read/all")
    @ResponseBody
    public Set<GradeReport> getAll(){
        return service.getAll();
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
