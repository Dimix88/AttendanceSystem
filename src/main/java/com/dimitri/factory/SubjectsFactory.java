package com.dimitri.factory;

import com.dimitri.domain.CollegeSubjects;
import com.dimitri.util.IdGenerator;

public class SubjectsFactory {

    public static CollegeSubjects getSubjects(String subYear, String subNm){
        return new CollegeSubjects.Builder().subjectCode(IdGenerator.generateId())
                .year(subYear)
                .subName(subNm)
                .build();
    }
}
