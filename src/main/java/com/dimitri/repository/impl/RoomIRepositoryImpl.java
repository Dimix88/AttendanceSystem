package com.dimitri.repository.impl;

import com.dimitri.repository.RoomIRepository;
import com.dimitri.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Repository("RoomRepository")
public class RoomIRepositoryImpl implements RoomIRepository {
    @Autowired
    private static RoomIRepositoryImpl repository = null;
    private Set<Room>rooms;
    private RoomIRepositoryImpl(){
        this.rooms = new HashSet<>();
    }

    private Room findRoom(String roomCode){
        for (Room room: this.rooms){
            if (room.getRoomCode().equals(roomCode))
                return room;
        }
        return null;     }
    public static RoomIRepository getRepository(){
        if(repository == null) repository = new RoomIRepositoryImpl();
        return repository;
    }
    @Override
    public Room create(Room room) {
        this.rooms.add(room);
        return room;
    }

    @Override
    public Room update(Room room) {
        Room toDelete = findRoom(room.getRoomCode());
        if(toDelete != null) {
            this.rooms.remove(toDelete);
            return create(room);
        }
        return null;
    }

    @Override
    public void delete(String roomCode) {
        Room class1 = findRoom(roomCode);
        if(class1 != null){
            this.rooms.remove(class1);
        }
    }

    @Override
    public Room read(String roomCode) {
        return findRoom(roomCode);
    }
    public Set<Room> getAll(){
        return this.rooms;
    }
}
