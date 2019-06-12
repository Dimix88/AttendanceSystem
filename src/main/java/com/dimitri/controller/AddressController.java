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
    @Qualifier("ServiceImpl2")

    private AddressService service;

    @PostMapping("/create")
    @ResponseBody
    public Address create(Address address){
        return service.create(address);
    }

    @PostMapping("/update")
    @ResponseBody
    public Address update(Address address){
        return service.update(address);
    }

    @PostMapping("/read/{id}")
    @ResponseBody
    public Address read(@PathVariable String id){
        return service.read(id);
    }

    @PostMapping("/read/all")
    @ResponseBody
    public Set<Address> getAll(){
        return service.getAll();
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
