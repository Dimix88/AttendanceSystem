package com.dimitri.controller;

import com.dimitri.domain.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.dimitri.service.AddressService;

import java.util.Set;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    @Qualifier("AddressServiceImpl")
    private AddressService service;

    @PostMapping("/create")
    @ResponseBody
    public Address create(@RequestBody Address address){
        return service.create(address);
    }

    @PutMapping("/update")
    @ResponseBody
    public Address update(@RequestBody Address address){
        return service.update(address);
    }

    @PostMapping("/read/{id}")
    @ResponseBody
    public Address read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Address> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
