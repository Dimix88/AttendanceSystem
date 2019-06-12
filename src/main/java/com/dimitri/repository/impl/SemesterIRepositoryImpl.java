package com.dimitri.repository.impl;

import com.dimitri.repository.SemesterIRepository;
import com.dimitri.domain.Semester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Repository("SemesterRepository")
public class SemesterIRepositoryImpl implements SemesterIRepository {
    @Autowired
    private static SemesterIRepositoryImpl repository = null;
    private Set<Semester> semesters;
    private SemesterIRepositoryImpl(){
        this.semesters = new HashSet<>();
    }

    private Semester findSemester(String semesterCode){
        for (Semester semester: this.semesters){
            if (semester.getSemesterCode().equals(semesterCode))
                return semester;
        }
        return null;     }
    public static SemesterIRepository getRepository(){
        if(repository == null) repository = new SemesterIRepositoryImpl();
        return repository;
    }

    @Override
    public Semester create(Semester semester) {
        this.semesters.add(semester);
        return semester;
    }

    @Override
    public Semester update(Semester semester) {
        Semester toDelete = findSemester(semester.getSemesterCode());
        if(toDelete != null) {
            this.semesters.remove(toDelete);
            return create(semester);
        }
        return null;
    }

    @Override
    public void delete(String semesterCode) {
        Semester class1 = findSemester(semesterCode);
        if(class1 != null){
            this.semesters.remove(class1);
        }
    }

    @Override
    public Semester read(String semesterCode) {
        return findSemester(semesterCode);
    }
    public Set<Semester> getAll(){
        return this.semesters;
    }
}
