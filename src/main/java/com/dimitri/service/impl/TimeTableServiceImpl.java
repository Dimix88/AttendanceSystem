package com.dimitri.service.impl;

import com.dimitri.repository.TimetableIRepository;
//import com.dimitri.repository.impl.TimetableIRepositoryImpl;
import com.dimitri.domain.CollegeTimetable;
import com.dimitri.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("TimeServiceImpl")
public class TimeTableServiceImpl implements TimetableService {
    public static TimetableService timetableService = null;

    @Autowired
    private TimetableIRepository repository;

    private TimeTableServiceImpl(){}

    public static TimetableService getTimetableService(){
        if (timetableService==null)timetableService = new TimeTableServiceImpl();
        return timetableService;
    }
    @Override
    public List<CollegeTimetable> getAll() {
        return this.repository.findAll();
    }

    @Override
    public CollegeTimetable create(CollegeTimetable collegeTimetable) {
        return this.repository.save(collegeTimetable);
    }

    @Override
    public CollegeTimetable update(CollegeTimetable collegeTimetable) {
        return this.repository.save(collegeTimetable);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public CollegeTimetable read(String s) {
        Optional<CollegeTimetable>optionalTimetable = this.repository.findById(s);
        return optionalTimetable.orElse(null);
    }
}
