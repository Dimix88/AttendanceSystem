package com.dimitri.factory;

import com.dimitri.domain.Room;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoomFactoryTest {

    @Test
    public void getRoom() {
        String name = "Lab";
        Room b = RoomFactory.getRoom("Lab");
        Assert.assertEquals(name, b.getRoomType());
        Assert.assertNotNull(b);
    }
}