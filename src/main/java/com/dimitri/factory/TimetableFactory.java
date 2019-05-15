package com.dimitri.factory;

import com.dimitri.domain.Timetable;
import com.dimitri.util.IdGenerator;

public class TimetableFactory {
    public static Timetable getTimetable(String times, String days){
        return new Timetable.Builder().ttID(IdGenerator.generateId())
                .time(times)
                .day(days)
                .build();
    }
}
