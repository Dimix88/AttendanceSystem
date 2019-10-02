package com.dimitri.factory;

import com.dimitri.domain.CollegeTimetable;
import com.dimitri.util.IdGenerator;

public class TimetableFactory {
    public static CollegeTimetable getTimetable(String times, String days){
        return new CollegeTimetable.Builder().ttID(IdGenerator.generateId())
                .time(times)
                .day(days)
                .build();
    }
}
