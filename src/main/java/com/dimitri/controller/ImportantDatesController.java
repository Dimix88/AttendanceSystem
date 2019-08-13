package com.dimitri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.dimitri.service.ImportantdatesService;
import com.dimitri.domain.ImportantDates;

import java.util.Set;

@RestController
@RequestMapping("/importantdates")
public class ImportantDatesController {
    @Autowired
    @Qualifier("DatesServiceImpl")

    private ImportantdatesService service;

    @PostMapping("/create")
    @ResponseBody
    public ImportantDates create(@RequestBody ImportantDates importantdates){
        return service.create(importantdates);
    }

    @PutMapping("/update")
    @ResponseBody
    public ImportantDates update(@RequestBody ImportantDates importantDates){
        return service.update(importantDates);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public ImportantDates read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<ImportantDates> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
