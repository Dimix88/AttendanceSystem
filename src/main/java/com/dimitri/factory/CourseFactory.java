package com.dimitri.factory;

import com.dimitri.domain.Course;
import com.dimitri.util.IdGenerator;

public class CourseFactory {

    public static Course getCourse(String name){

        return new Course.Builder().courseId(IdGenerator.generateId())
                .courseName(name)
                .build();
    }
}
