package com.dimitri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.dimitri.service.RoomService;
import com.dimitri.domain.Room;

import java.util.Set;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    @Qualifier("RoomServiceImpl")
    private RoomService service;

    @PostMapping("/create")
    @ResponseBody
    public Room create(@RequestBody Room room){
        return service.create(room);
    }

    @PutMapping("/update")
    @ResponseBody
    public Room update(@RequestBody Room room){
        return service.update(room);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Room read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Room> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
