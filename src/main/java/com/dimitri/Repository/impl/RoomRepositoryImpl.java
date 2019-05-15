package com.dimitri.Repository.impl;

import com.dimitri.Repository.Repository;
import com.dimitri.Repository.RoomRepository;
import com.dimitri.domain.Room;

import java.util.HashSet;
import java.util.Set;

public class RoomRepositoryImpl implements RoomRepository {
    private static RoomRepositoryImpl repository = null;
    private Set<Room>rooms;
    private RoomRepositoryImpl(){
        this.rooms = new HashSet<>();
    }

    private Room findRoom(String roomCode){
        for (Room room: this.rooms){
            if (room.getRoomCode().equals(roomCode))
                return room;
        }
        return null;     }
    public static RoomRepository getRepository(){
        if(repository == null) repository = new RoomRepositoryImpl();
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
