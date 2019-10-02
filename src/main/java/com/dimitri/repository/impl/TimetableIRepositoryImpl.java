/**package com.dimitri.repository.impl;

import com.dimitri.repository.TimetableIRepository;
import com.dimitri.domain.CollegeTimetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Repository("TimetableRepository")
public class TimetableIRepositoryImpl implements TimetableIRepository {
    @Autowired
    private static TimetableIRepositoryImpl repository = null;
    private Set<CollegeTimetable> timetables;

    private TimetableIRepositoryImpl(){
        this.timetables = new HashSet<>();
    }

    private CollegeTimetable findTimetable(String ttID){
        for (CollegeTimetable classes2: this.timetables){
            if (classes2.getTtID().equals(ttID))
                return classes2;
        }
        return null;    }
    public static TimetableIRepository getRepository(){
        if(repository == null) repository = new TimetableIRepositoryImpl();
        return repository;
    }
    @Override
    public CollegeTimetable create(CollegeTimetable timetable) {
        this.timetables.add(timetable);
        return timetable;
    }

    @Override
    public CollegeTimetable update(CollegeTimetable timetable) {
        CollegeTimetable toDelete = findTimetable(timetable.getTtID());
        if(toDelete != null) {
            this.timetables.remove(toDelete);
            return create(timetable);
        }
        return null;
    }

    @Override
    public void delete(String ttID) {
        CollegeTimetable class1 = findTimetable(ttID);
        if(class1 != null){
            this.timetables.remove(class1);
        }    }

    @Override
    public CollegeTimetable read(String ttID) {
        return findTimetable(ttID);
    }
    public Set<CollegeTimetable> getAll(){
        return this.timetables;
    }
}
**/