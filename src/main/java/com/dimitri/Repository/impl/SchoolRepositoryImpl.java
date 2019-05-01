package com.dimitri.Repository.impl;

import com.dimitri.Repository.Repository;
import com.dimitri.Repository.SchoolRepository;
import com.dimitri.domain.School;

import java.util.HashSet;
import java.util.Set;

public class SchoolRepositoryImpl implements SchoolRepository {
    private static SchoolRepositoryImpl repository = null;
    private Set<School> schools;
    private SchoolRepositoryImpl(){
        this.schools = new HashSet<>();
    }

    private School findSchool(String schoolCode){
        for (School school: this.schools){
            if (school.getSchoolCode().equals(schoolCode))
                return school;
        }
        return null;     }
    public static SchoolRepository getRepository(){
        if(repository == null) repository = new SchoolRepositoryImpl();
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
        this.schools.removeIf(school -> school.getSchoolCode()==schoolCode);
    }

    @Override
    public School read(String schoolCode) {
        return findSchool(schoolCode);
    }
    public Set<School> getAll(){
        return this.schools;
    }
}
