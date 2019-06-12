package com.dimitri.repository;

import com.dimitri.domain.Room;
import com.dimitri.repository.IRepository;
import org.springframework.stereotype.Repository;
import java.util.Set;

public interface RoomIRepository extends IRepository<Room, String> {
    Set<Room>getAll();
}
