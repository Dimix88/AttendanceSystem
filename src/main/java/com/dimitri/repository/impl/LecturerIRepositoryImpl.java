package com.dimitri.repository.impl;

import com.dimitri.repository.LecturerIRepository;
import com.dimitri.domain.Lecturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Repository("LecturerRepository")
public class LecturerIRepositoryImpl implements LecturerIRepository {
    @Autowired
    private static LecturerIRepositoryImpl repository = null;
    private Set<Lecturer>lecturers;

    private LecturerIRepositoryImpl(){
        this.lecturers = new HashSet<>();
    }

    private Lecturer findLecturer(String lecId){
        for (Lecturer lecturer: this.lecturers){
            if (lecturer.getLecId().equals(lecId))
                return lecturer;
        }
        return null;     }

    public static LecturerIRepository getRepository(){
        if(repository == null) repository = new LecturerIRepositoryImpl();
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
        Lecturer lecturer = findLecturer(lecId);
        if(lecturer != null){
            this.lecturers.remove(lecturer);
        }
    }

    @Override
    public Lecturer read(String lecId) {
        return findLecturer(lecId);
    }
    public Set<Lecturer> getAll(){
        return this.lecturers;
    }
}
