package com.dimitri.service;

import com.dimitri.domain.Timetable;

import java.util.Set;

public interface TimetableService extends IService<Timetable, String> {
    Set<Timetable>getAll();
}
