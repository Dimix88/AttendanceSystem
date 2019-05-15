package com.dimitri.Repository.impl;

import com.dimitri.Repository.RoomRepository;
import com.dimitri.domain.Room;
import com.dimitri.factory.RoomFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class RoomRepositoryImplTest {

    private RoomRepository repository;
    private Room c1;
    Set<Room> rooms = new HashSet<>();

    @Before
    public void setUp() throws Exception {
        this.repository = RoomRepositoryImpl.getRepository();
        c1 = RoomFactory.getRoom("Large");

    }

    @Test
    public void create() {
        Room room= this.repository.create(this.c1);
        String name = "Large";
        System.out.println("In create, created = " + room);
        Assert.assertEquals(name,room.getRoomType());
        Assert.assertNotNull(rooms);
        Assert.assertSame(room, this.c1);
    }

    @Test
    public void update() {
        Room room= this.repository.create(this.c1);
        String newRoomCode = "133";
        Room newRoom = new Room.Builder().copy(room).roomCode(newRoomCode).build();
        this.repository.create(newRoom);
        System.out.println("In update, Will update = " + newRoom);
        Room updated = this.repository.update(newRoom);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newRoom.getRoomCode(), updated.getRoomCode());
    }

    @Test
    public void delete() {
        Room room= this.repository.create(this.c1);
        this.repository.delete(room.getRoomCode());
        System.out.println(this.rooms);
    }

    @Test
    public void read() {
        Room room= this.repository.create(this.c1);
        System.out.println("In read, courseId = "+ room.getRoomCode());
        Room read = this.repository.read(room.getRoomCode());
        System.out.println("In read, read = "+ read);
        Assert.assertEquals(c1.getRoomCode(), this.repository.read(c1.getRoomCode()).getRoomCode());

    }


    @Test
    public void getAll() {
        Set<Room> roomsSet = this.repository.getAll();
        System.out.println("In getAll, all = " + roomsSet);
        Assert.assertSame(1, roomsSet.size());
    }
}