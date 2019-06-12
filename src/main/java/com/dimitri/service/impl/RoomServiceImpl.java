package com.dimitri.service.impl;

import com.dimitri.repository.RoomIRepository;
import com.dimitri.repository.impl.RoomIRepositoryImpl;
import com.dimitri.domain.Room;
import com.dimitri.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.Set;
@Service("ServiceImpl13")
public class RoomServiceImpl implements RoomService {
    @Autowired
    @Qualifier("RoomRepository")
    private static RoomServiceImpl service = null;
    private RoomIRepository repository = null;

    private RoomServiceImpl(){
        this.repository = RoomIRepositoryImpl.getRepository();
    }
    public static RoomServiceImpl getService(){
        if(service == null) service = new RoomServiceImpl();
        return service;
    }
    @Override
    public Room create(Room room) {
        return this.repository.create(room);
    }

    @Override
    public Room update(Room room) {
        return this.repository.update(room);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Room read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Room> getAll() {
        return this.repository.getAll();
    }
}
