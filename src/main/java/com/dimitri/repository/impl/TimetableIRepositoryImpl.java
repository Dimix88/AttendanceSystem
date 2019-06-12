package com.dimitri.repository.impl;

import com.dimitri.repository.TimetableIRepository;
import com.dimitri.domain.Timetable;
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
    private Set<Timetable> timetables;

    private TimetableIRepositoryImpl(){
        this.timetables = new HashSet<>();
    }

    private Timetable findTimetable(String ttID){
        for (Timetable classes2: this.timetables){
            if (classes2.getTtID().equals(ttID))
                return classes2;
        }
        return null;    }
    public static TimetableIRepository getRepository(){
        if(repository == null) repository = new TimetableIRepositoryImpl();
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
