package com.dimitri.service.impl;

import com.dimitri.Repository.TimetableRepository;
import com.dimitri.Repository.impl.TimetableRepositoryImpl;
import com.dimitri.domain.Timetable;
import com.dimitri.service.TimetableService;

import java.sql.Time;
import java.util.Set;

public class TimeTableServiceImpl implements TimetableService {
    private static TimeTableServiceImpl service = null;
    private TimetableRepository repository = null;

    private TimeTableServiceImpl(){
        this.repository = TimetableRepositoryImpl.getRepository();
    }
    public static TimeTableServiceImpl getService(){
        if(service == null) service = new TimeTableServiceImpl();
        return service;
    }
    @Override
    public Set<Timetable> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Timetable create(Timetable timetable) {
        return this.repository.create(timetable);
    }

    @Override
    public Timetable update(Timetable timetable) {
        return this.repository.update(timetable);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Timetable read(String s) {
        return this.repository.read(s);
    }
}
