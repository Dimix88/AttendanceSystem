package com.dimitri.repository.impl;

import com.dimitri.repository.SubjectsIRepository;
import com.dimitri.domain.Subjects;
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
    private Set<Subjects> subjects;

    private SubjectsIRepositoryImpl(){
        this.subjects = new HashSet<>();
    }

    private Subjects findSubjects(String subjectCode){
        for (Subjects classes2: this.subjects){
            if (classes2.getSubjectCode().equals(subjectCode))
                return classes2;
        }
        return null;    }
    public static SubjectsIRepository getRepository(){
        if(repository == null) repository = new SubjectsIRepositoryImpl();
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
