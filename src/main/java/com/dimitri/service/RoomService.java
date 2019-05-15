package com.dimitri.service;

import com.dimitri.domain.Room;

import java.util.Set;

public interface RoomService extends IService<Room, String> {
    Set<Room>getAll();
}
