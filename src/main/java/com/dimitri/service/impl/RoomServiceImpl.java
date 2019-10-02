package com.dimitri.service.impl;

import com.dimitri.repository.RoomIRepository;
//import com.dimitri.repository.impl.RoomIRepositoryImpl;
import com.dimitri.domain.Room;
import com.dimitri.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("RoomServiceImpl")
public class RoomServiceImpl implements RoomService {
    public static RoomService roomService = null;

    @Autowired
    private RoomIRepository repository;

    private RoomServiceImpl(){}

    public static RoomService getRoomService(){
        if (roomService==null)roomService = new RoomServiceImpl();
        return roomService;
    }
    @Override
    public Room create(Room room) {
        return this.repository.save(room);
    }

    @Override
    public Room update(Room room) {
        return this.repository.save(room);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Room read(String s) {
        Optional<Room>optionalRoom = this.repository.findById(s);
        return optionalRoom.orElse(null);
    }

    @Override
    public List<Room> getAll() {
        return this.repository.findAll();
    }
}
