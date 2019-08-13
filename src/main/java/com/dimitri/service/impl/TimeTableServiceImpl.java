package com.dimitri.service.impl;

import com.dimitri.repository.TimetableIRepository;
import com.dimitri.repository.impl.TimetableIRepositoryImpl;
import com.dimitri.domain.Timetable;
import com.dimitri.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service("TimeServiceImpl")
public class TimeTableServiceImpl implements TimetableService {
    @Autowired
    @Qualifier("TimetableRepository")
    private TimetableIRepository repository = null;

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
