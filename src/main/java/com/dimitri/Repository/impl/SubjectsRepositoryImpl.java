package com.dimitri.Repository.impl;

import com.dimitri.Repository.SubjectsRepository;
import com.dimitri.domain.Subjects;

import java.util.HashSet;
import java.util.Set;

public class SubjectsRepositoryImpl implements SubjectsRepository {
    private static SubjectsRepositoryImpl repository = null;
    private Set<Subjects> subjects;

    private SubjectsRepositoryImpl(){
        this.subjects = new HashSet<>();
    }

    private Subjects findSubjects(String subjectCode){
        for (Subjects classes2: this.subjects){
            if (classes2.getSubjectCode().equals(subjectCode))
                return classes2;
        }
        return null;    }
    public static SubjectsRepository getRepository(){
        if(repository == null) repository = new SubjectsRepositoryImpl();
        return repository;
    }
    @Override
    public Subjects create(Subjects subjects) {
        this.subjects.add(subjects);
        return subjects;
    }

    @Override
    public Subjects update(Subjects subjects) {
        Subjects toDelete = findSubjects(subjects.getSubjectCode());
        if(toDelete != null) {
            this.subjects.remove(toDelete);
            return create(subjects);
        }
        return null;
    }

    @Override
    public void delete(String subjectCode) {
        Subjects class1 = findSubjects(subjectCode);
        if(class1 != null){
            this.subjects.remove(class1);
        }    }

    @Override
    public Subjects read(String subjectCode) {
        return findSubjects(subjectCode);
    }
    public Set<Subjects> getAll(){
        return this.subjects;
    }
}
