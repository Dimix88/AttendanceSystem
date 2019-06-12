package com.dimitri.repository;

import com.dimitri.domain.Timetable;
import com.dimitri.repository.IRepository;
import org.springframework.stereotype.Repository;
import java.util.Set;

public interface TimetableIRepository extends IRepository<Timetable, String> {
    Set<Timetable>getAll();
}
