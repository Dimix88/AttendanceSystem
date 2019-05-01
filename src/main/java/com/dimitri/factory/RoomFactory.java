package com.dimitri.factory;

import com.dimitri.domain.Room;
import com.dimitri.util.IdGenerator;

public class RoomFactory {
    public static Room getRoom(String rmType){
        return new Room.Builder().roomCode(IdGenerator.generateId())
                .roomType(rmType)
                .bldgCode(IdGenerator.generateId())
                .build();
    }
}
