package com.dimitri.service.impl;

import com.dimitri.repository.RoomIRepository;
//import com.dimitri.repository.impl.RoomIRepositoryImpl;
import com.dimitri.domain.Room;
import com.dimitri.factory.RoomFactory;
import com.dimitri.service.RoomService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RoomServiceImplTest {
    private RoomService roomService;
    private RoomIRepository repository;
    private Room c1;

    @Before
    public void setUp() throws Exception {
        this.roomService = RoomServiceImpl.getRoomService();
        c1 = RoomFactory.getRoom("Large");
        this.roomService.create(c1);
    }

    @Test
    public void create() {
        Room room= RoomFactory.getRoom("Small");
        this.roomService.create(room);
        String name = "Small";
        Assert.assertEquals(room.getRoomCode(),roomService.read(room.getRoomCode()).getRoomType());
        Assert.assertNotNull(room);
        Assert.assertEquals(name, roomService.read(room.getRoomCode()).getRoomType());
        Assert.assertSame(room, roomService.read(room.getRoomCode()));
    }

    @Test
    public void update() {
        String newRoomType = "Tiny";
        Room newRoom = new Room.Builder().copy(c1).roomCode(newRoomType).build();
        this.roomService.update(newRoom);
        Assert.assertEquals(newRoom,roomService.read(c1.getRoomCode()));
    }

    @Test
    public void delete() {
        Room deleteRoom= RoomFactory.getRoom("Big");
        roomService.create(deleteRoom);
        roomService.delete(deleteRoom.getRoomCode());
        Room result = roomService.read(deleteRoom.getRoomCode());
        Assert.assertFalse(roomService.getAll().iterator().next().getRoomType().contains("Big"));
        Assert.assertNull(result);
    }

    @Test
    public void read() {
        Room read = this.roomService.create(this.c1);
        Assert.assertEquals(read, roomService.read(read.getRoomCode()));
        Assert.assertEquals(read, roomService.read(c1.getRoomCode()));

    }


    @Test
    public void getAll() {
        List<Room> roomsSet = this.roomService.getAll();
        System.out.println("In getAll, all = " + roomsSet);
        Assert.assertSame(roomsSet.size(),roomService.getAll().size());
    }
}