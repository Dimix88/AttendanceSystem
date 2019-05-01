package com.dimitri.Repository;

import com.dimitri.domain.Room;

import java.util.Set;

public interface RoomRepository extends Repository<Room, String> {
    Set<Room>getAll();
}
