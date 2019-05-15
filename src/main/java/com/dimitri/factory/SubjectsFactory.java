package com.dimitri.factory;

import com.dimitri.domain.Subjects;
import com.dimitri.util.IdGenerator;

public class SubjectsFactory {

    public static Subjects getSubjects(String subYear, String subNm){
        return new Subjects.Builder().subjectCode(IdGenerator.generateId())
                .year(subYear)
                .subName(subNm)
                .build();
    }
}
