package com.dimitri.factory;

import com.dimitri.domain.Enroll;

public class EnrollFactory {

    public static Enroll getEnroll(String enCode, String id, String date, String grade){
        return new Enroll.Builder().courseCode(enCode)
                .studentId(id)
                .enrollDate(date)
                .enrollGrade(grade)
                .build();
    }
}
