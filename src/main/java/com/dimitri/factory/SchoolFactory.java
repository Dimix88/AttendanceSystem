package com.dimitri.factory;

import com.dimitri.domain.School;
import com.dimitri.util.IdGenerator;

public class SchoolFactory {
    public static School getSchool(String sName){
        return new School.Builder().schoolCode(IdGenerator.generateId())
                .schoolName(sName)
                .lecId(IdGenerator.generateId())
                .build();
    }
}
