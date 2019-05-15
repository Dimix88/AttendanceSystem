package com.dimitri.Repository.impl;

import com.dimitri.Repository.TimetableRepository;
import com.dimitri.domain.Timetable;

import java.util.HashSet;
import java.util.Set;

public class TimetableRepositoryImpl implements TimetableRepository {
    private static TimetableRepositoryImpl repository = null;
    private Set<Timetable> timetables;

    private TimetableRepositoryImpl(){
        this.timetables = new HashSet<>();
    }

    private Timetable findTimetable(String ttID){
        for (Timetable classes2: this.timetables){
            if (classes2.getTtID().equals(ttID))
                return classes2;
        }
        return null;    }
    public static TimetableRepository getRepository(){
        if(repository == null) repository = new TimetableRepositoryImpl();
        return repository;
    }
    @Override
    public Timetable create(Timetable timetable) {
        this.timetables.add(timetable);
        return timetable;
    }

    @Override
    public Timetable update(Timetable timetable) {
        Timetable toDelete = findTimetable(timetable.getTtID());
        if(toDelete != null) {
            this.timetables.remove(toDelete);
            return create(timetable);
        }
        return null;
    }

    @Override
    public void delete(String ttID) {
        Timetable class1 = findTimetable(ttID);
        if(class1 != null){
            this.timetables.remove(class1);
        }    }

    @Override
    public Timetable read(String ttID) {
        return findTimetable(ttID);
    }
    public Set<Timetable> getAll(){
        return this.timetables;
    }
}
