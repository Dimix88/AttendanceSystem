package com.dimitri.factory;

import com.dimitri.domain.Classes;
import com.dimitri.util.IdGenerator;

public class ClassesFactory {

    public static Classes getClasses(String crCode, String lCode, String time){
        return new Classes.Builder().classCode(IdGenerator.generateId())
                .courseCode(crCode)
                .lecturerId(lCode)
                .classTime(time)
                .build();
    }
}
