package com.dimitri.Repository.impl;

import com.dimitri.Repository.Repository;
import com.dimitri.Repository.SemesterRepository;
import com.dimitri.domain.Semester;

import java.util.HashSet;
import java.util.Set;

public class SemesterRepositoryImpl implements SemesterRepository {
    private static SemesterRepositoryImpl repository = null;
    private Set<Semester> semesters;
    private SemesterRepositoryImpl(){
        this.semesters = new HashSet<>();
    }

    private Semester findSemester(String semesterCode){
        for (Semester semester: this.semesters){
            if (semester.getSemesterCode().equals(semesterCode))
                return semester;
        }
        return null;     }
    public static SemesterRepository getRepository(){
        if(repository == null) repository = new SemesterRepositoryImpl();
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
