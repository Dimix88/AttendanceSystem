package com.dimitri.service.impl;

import com.dimitri.Repository.RoomRepository;
import com.dimitri.Repository.impl.RoomRepositoryImpl;
import com.dimitri.domain.Room;
import com.dimitri.service.RoomService;

import java.util.Set;

public class RoomServiceImpl implements RoomService {
    private static RoomServiceImpl service = null;
    private RoomRepository repository = null;

    private RoomServiceImpl(){
        this.repository = RoomRepositoryImpl.getRepository();
    }
    public static RoomServiceImpl getService(){
        if(service == null) service = new RoomServiceImpl();
        return service;
    }
    @Override
    public Room create(Room room) {
        return this.repository.create(room);
    }

    @Override
    public Room update(Room room) {
        return this.repository.update(room);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Room read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Room> getAll() {
        return this.repository.getAll();
    }
}
