package com.dimitri.service;

import com.dimitri.domain.Room;

import java.util.List;

public interface RoomService extends IService<Room, String> {
    List<Room> getAll();
}
