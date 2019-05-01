package com.dimitri.Repository.impl;

import com.dimitri.Repository.EnrollRepository;
import com.dimitri.Repository.Repository;
import com.dimitri.domain.Enroll;


import java.util.HashSet;
import java.util.Set;

public class EnrollRepositoryImpl implements EnrollRepository {
    private static EnrollRepositoryImpl repository = null;
    private Set<Enroll>enrolls;
    private EnrollRepositoryImpl(){
        this.enrolls = new HashSet<>();
    }

    private Enroll findStudent(String studentId){
        for (Enroll enroll: this.enrolls){
            if (enroll.getStudentId().equals(studentId))
                return enroll;
        }
        return null;     }

    public static EnrollRepository getRepository(){
        if(repository == null) repository = new EnrollRepositoryImpl();
        return repository;
    }
    @Override
    public Enroll create(Enroll enroll) {
        this.enrolls.add(enroll);
        return enroll;
    }

    @Override
    public Enroll update(Enroll enroll) {
        Enroll toDelete = findStudent(enroll.getStudentId());
        if(toDelete != null) {
            this.enrolls.remove(toDelete);
            return create(enroll);
        }
        return null;
    }

    @Override
    public void delete(String studentId) {
        this.enrolls.removeIf(enroll -> enroll.getStudentId()==studentId);
    }

    @Override
    public Enroll read(String studentId) {
        return findStudent(studentId);
    }
    public Set<Enroll> getAll(){
        return this.enrolls;
    }
}
