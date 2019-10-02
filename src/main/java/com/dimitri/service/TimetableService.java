package com.dimitri.service;

import com.dimitri.domain.CollegeTimetable;

import java.util.List;

public interface TimetableService extends IService<CollegeTimetable, String> {
    List<CollegeTimetable> getAll();
}
