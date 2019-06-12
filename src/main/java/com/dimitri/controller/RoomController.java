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
    @Qualifier("ServiceImpl13")

    private RoomService service;

    @PostMapping("/create")
    @ResponseBody
    public Room create(Room room){
        return service.create(room);
    }

    @PostMapping("/update")
    @ResponseBody
    public Room update(Room room){
        return service.update(room);
    }

    @PostMapping("/read/{id}")
    @ResponseBody
    public Room read(@PathVariable String id){
        return service.read(id);
    }

    @PostMapping("/read/all")
    @ResponseBody
    public Set<Room> getAll(){
        return service.getAll();
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
