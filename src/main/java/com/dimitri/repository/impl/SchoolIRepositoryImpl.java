package com.dimitri.repository.impl;

import com.dimitri.repository.SchoolIRepository;
import com.dimitri.domain.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Repository("SchoolRepository")
public class SchoolIRepositoryImpl implements SchoolIRepository {
    @Autowired
    private static SchoolIRepositoryImpl repository = null;
    private Set<School> schools;
    private SchoolIRepositoryImpl(){
        this.schools = new HashSet<>();
    }

    private School findSchool(String schoolCode){
        for (School school: this.schools){
            if (school.getSchoolCode().equals(schoolCode))
                return school;
        }
        return null;     }
    public static SchoolIRepository getRepository(){
        if(repository == null) repository = new SchoolIRepositoryImpl();
        return repository;
    }
    @Override
    public School create(School school) {
        this.schools.add(school);
        return school;
    }

    @Override
    public School update(School school) {
        School toDelete = findSchool(school.getSchoolCode());
        if(toDelete != null) {
            this.schools.remove(toDelete);
            return create(school);
        }
        return null;
    }

    @Override
    public void delete(String schoolCode) {
        School class1 = findSchool(schoolCode);
        if(class1 != null){
            this.schools.remove(class1);
        }
    }

    @Override
    public School read(String schoolCode) {
        return findSchool(schoolCode);
    }
    public Set<School> getAll(){
        return this.schools;
    }
}
