package com.dimitri.Repository.impl;

import com.dimitri.Repository.LecturerRepository;
import com.dimitri.Repository.Repository;
import com.dimitri.domain.Lecturer;

import java.util.HashSet;
import java.util.Set;

public class LecturerRepositoryImpl implements LecturerRepository {
    private static LecturerRepositoryImpl repository = null;
    private Set<Lecturer>lecturers;

    private LecturerRepositoryImpl(){
        this.lecturers = new HashSet<>();
    }

    private Lecturer findLecturer(String lecId){
        for (Lecturer lecturer: this.lecturers){
            if (lecturer.getLecId().equals(lecId))
                return lecturer;
        }
        return null;     }

    public static LecturerRepository getRepository(){
        if(repository == null) repository = new LecturerRepositoryImpl();
        return repository;
    }
    @Override
    public Lecturer create(Lecturer lecturer) {
        this.lecturers.add(lecturer);
        return lecturer;
    }

    @Override
    public Lecturer update(Lecturer lecturer) {
        Lecturer toDelete = findLecturer(lecturer.getLecId());
        if(toDelete != null) {
            this.lecturers.remove(toDelete);
            return create(lecturer);
        }
        return null;
    }

    @Override
    public void delete(String lecId) {
        this.lecturers.removeIf(lecturer -> lecturer.getLecId()==lecId);
    }

    @Override
    public Lecturer read(String lecId) {
        return findLecturer(lecId);
    }
    public Set<Lecturer> getAll(){
        return this.lecturers;
    }
}
