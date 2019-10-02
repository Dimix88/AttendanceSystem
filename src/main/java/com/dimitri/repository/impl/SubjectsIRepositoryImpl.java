/**package com.dimitri.repository.impl;

import com.dimitri.repository.SubjectsIRepository;
import com.dimitri.domain.CollegeSubjects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Repository("SubjectsRepository")
public class SubjectsIRepositoryImpl implements SubjectsIRepository {
    @Autowired
    private static SubjectsIRepositoryImpl repository = null;
    private Set<CollegeSubjects> subjects;

    private SubjectsIRepositoryImpl(){
        this.subjects = new HashSet<>();
    }

    private CollegeSubjects findSubjects(String subjectCode){
        for (CollegeSubjects classes2: this.subjects){
            if (classes2.getSubjectCode().equals(subjectCode))
                return classes2;
        }
        return null;    }
    public static SubjectsIRepository getRepository(){
        if(repository == null) repository = new SubjectsIRepositoryImpl();
        return repository;
    }
    @Override
    public CollegeSubjects create(CollegeSubjects subjects) {
        this.subjects.add(subjects);
        return subjects;
    }

    @Override
    public CollegeSubjects update(CollegeSubjects subjects) {
        CollegeSubjects toDelete = findSubjects(subjects.getSubjectCode());
        if(toDelete != null) {
            this.subjects.remove(toDelete);
            return create(subjects);
        }
        return null;
    }

    @Override
    public void delete(String subjectCode) {
        CollegeSubjects class1 = findSubjects(subjectCode);
        if(class1 != null){
            this.subjects.remove(class1);
        }    }

    @Override
    public CollegeSubjects read(String subjectCode) {
        return findSubjects(subjectCode);
    }
    public Set<CollegeSubjects> getAll(){
        return this.subjects;
    }
}
**/