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
    @Qualifier("ServiceImpl9")

    private ImportantdatesService service;

    @PostMapping("/create")
    @ResponseBody
    public ImportantDates create(ImportantDates importantdates){
        return service.create(importantdates);
    }

    @PostMapping("/update")
    @ResponseBody
    public ImportantDates update(ImportantDates importantDates){
        return service.update(importantDates);
    }

    @PostMapping("/read/{id}")
    @ResponseBody
    public ImportantDates read(@PathVariable String id){
        return service.read(id);
    }

    @PostMapping("/read/all")
    @ResponseBody
    public Set<ImportantDates> getAll(){
        return service.getAll();
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
