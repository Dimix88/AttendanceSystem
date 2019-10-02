/**package com.dimitri.repository.impl;

import com.dimitri.repository.EnrollIRepository;
import com.dimitri.domain.Enroll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Repository("EnrollRepository")
public class EnrollIRepositoryImpl implements EnrollIRepository {
    @Autowired
    private static EnrollIRepositoryImpl repository = null;
    private Set<Enroll>enrolls;
    private EnrollIRepositoryImpl(){
        this.enrolls = new HashSet<>();
    }

    private Enroll findStudent(String studentId){
        for (Enroll enroll: this.enrolls){
            if (enroll.getStudentId().equals(studentId))
                return enroll;
        }
        return null;     }

    public static EnrollIRepository getRepository(){
        if(repository == null) repository = new EnrollIRepositoryImpl();
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
        Enroll enroll = findStudent(studentId);
        if(enroll != null){
            this.enrolls.remove(enroll);
        }
    }

    @Override
    public Enroll read(String studentId) {
        return findStudent(studentId);
    }
    public Set<Enroll> getAll(){
        return this.enrolls;
    }
}
**/