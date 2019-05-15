package com.dimitri.Repository;

import com.dimitri.domain.Timetable;

import java.util.Set;

public interface TimetableRepository extends Repository<Timetable, String> {
    Set<Timetable>getAll();
}
